package app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource

import app.practice.practicecleanarchitecturetmdbclient.data.api.TMDBService
import app.practice.practicecleanarchitecturetmdbclient.data.model.artist.ArtistList
import retrofit2.Response
import javax.inject.Inject

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}

class ArtistRemoteDatasourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDatasource {

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(api_key = apiKey)
    }

}