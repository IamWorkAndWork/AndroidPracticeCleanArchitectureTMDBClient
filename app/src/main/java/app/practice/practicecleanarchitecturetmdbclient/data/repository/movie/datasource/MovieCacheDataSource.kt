package app.practice.practicecleanarchitecturetmdbclient.data.repository.movie

import app.practice.practicecleanarchitecturetmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = arrayListOf<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

}