package app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource

import app.practice.practicecleanarchitecturetmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists: List<Artist>)
}

class ArtistCacheDataSourceImpl : ArtistCacheDataSource{

    private var artistList = arrayListOf<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return  artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

}