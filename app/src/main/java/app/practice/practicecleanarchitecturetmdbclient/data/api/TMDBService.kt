package app.practice.practicecleanarchitecturetmdbclient.data.api

import app.practice.practicecleanarchitecturetmdbclient.data.model.artist.ArtistList
import app.practice.practicecleanarchitecturetmdbclient.data.model.movie.MovieList
import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShow
import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("api_key") apiKey: String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query("api_key") api_key: String
    ): Response<ArtistList>

}