package app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource

import app.practice.practicecleanarchitecturetmdbclient.data.database.ArtistDao
import app.practice.practicecleanarchitecturetmdbclient.data.model.artist.Artist
import javax.inject.Inject

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()

}

class ArtistLocalDataSourceImpl @Inject constructor(
    private val artistDao: ArtistDao
) : ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        return artistDao.saveArtist(artists)
    }

    override suspend fun clearAll() {
        return artistDao.deleteAllArtists()
    }

}