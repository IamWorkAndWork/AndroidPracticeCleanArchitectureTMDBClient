package app.practice.practicecleanarchitecturetmdbclient.domain.usecase

import app.practice.practicecleanarchitecturetmdbclient.data.model.movie.Movie
import app.practice.practicecleanarchitecturetmdbclient.data.repository.movie.MovieRepository
import javax.inject.Inject

interface GetMoviesUseCase {
    suspend fun execute(): List<Movie>
}

class GetMoviesUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : GetMoviesUseCase {

    override suspend fun execute(): List<Movie> {
        return movieRepository.getMovies()
    }

}