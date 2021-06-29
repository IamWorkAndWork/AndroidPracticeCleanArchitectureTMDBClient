package app.practice.practicecleanarchitecturetmdbclient.data.repository.artist

import android.util.Log
import app.practice.practicecleanarchitecturetmdbclient.data.model.artist.Artist
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import javax.inject.Inject

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>
    suspend fun updateArtists(): List<Artist>
}

class ArtistRepositoryImpl @Inject constructor(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtist = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist)
        artistCacheDataSource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        val artistList = mutableListOf<Artist>()
        try {
            artistList.addAll(artistCacheDataSource.getArtistsFromCache())
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList.addAll(getArtistsFromDB())
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }

    private suspend fun getArtistsFromDB(): Collection<Artist> {
        val artistList = mutableListOf<Artist>()
        try {
            artistList.addAll(artistLocalDataSource.getArtistsFromDB())
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList.addAll(getArtistsFromApi())
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    private suspend fun getArtistsFromApi(): List<Artist> {
        val artistList: MutableList<Artist> = mutableListOf()
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList.addAll(body.artists)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

}