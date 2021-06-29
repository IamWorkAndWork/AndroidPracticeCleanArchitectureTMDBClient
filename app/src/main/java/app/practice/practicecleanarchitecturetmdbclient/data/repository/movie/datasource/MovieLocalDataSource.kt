package app.practice.practicecleanarchitecturetmdbclient.data.repository.movie

import app.practice.practicecleanarchitecturetmdbclient.data.database.MovieDao
import app.practice.practicecleanarchitecturetmdbclient.data.model.movie.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}

class MovieLocalDataSourceImpl @Inject constructor(private val movieDao: MovieDao) :
    MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        movieDao.saveMovies(movies)
    }

    override suspend fun clearAll() {
        movieDao.deleteAllMovies()
    }

}