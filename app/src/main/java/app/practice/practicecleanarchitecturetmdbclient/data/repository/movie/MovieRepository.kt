package app.practice.practicecleanarchitecturetmdbclient.data.repository.movie

import android.util.Log
import app.practice.practicecleanarchitecturetmdbclient.data.model.movie.Movie
import javax.inject.Inject

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun updateMovies(): List<Movie>
}

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        val movieList = mutableListOf<Movie>()
        try {
            movieList.addAll(movieCacheDataSource.getMoviesFromCache())
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList.addAll(getMoviesFromDB())
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        val movieList = mutableListOf<Movie>()
        try {
            movieList.addAll(movieLocalDataSource.getMoviesFromDB())
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList.addAll(getMoviesFromAPI())
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        val movieList = mutableListOf<Movie>()
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList.addAll(body.movies)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

}