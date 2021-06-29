package app.practice.practicecleanarchitecturetmdbclient.data.repository.tvshow

import app.practice.practicecleanarchitecturetmdbclient.data.api.TMDBService
import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShow
import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import javax.inject.Inject

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}

class TvShowRemoteDataSourceImpl @Inject constructor(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }

}