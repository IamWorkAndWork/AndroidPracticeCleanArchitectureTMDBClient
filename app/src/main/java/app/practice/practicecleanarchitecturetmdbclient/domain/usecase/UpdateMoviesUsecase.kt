package app.practice.practicecleanarchitecturetmdbclient.domain.usecase

import app.practice.practicecleanarchitecturetmdbclient.data.model.movie.Movie
import app.practice.practicecleanarchitecturetmdbclient.data.repository.movie.MovieRepository
import javax.inject.Inject

interface UpdateMoviesUsecase {
    suspend fun execute(): List<Movie>
}

class UpdateMoviesUsecaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : UpdateMoviesUsecase{

    override suspend fun execute(): List<Movie> {
        return movieRepository.getMovies()
    }

}