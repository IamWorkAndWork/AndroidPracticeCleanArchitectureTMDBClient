package app.practice.practicecleanarchitecturetmdbclient.data.repository.movie

import app.practice.practicecleanarchitecturetmdbclient.data.api.TMDBService
import app.practice.practicecleanarchitecturetmdbclient.data.model.movie.MovieList
import retrofit2.Response
import javax.inject.Inject

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}

class MovieRemoteDatasourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDatasource {

    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey = apiKey)
    }

}