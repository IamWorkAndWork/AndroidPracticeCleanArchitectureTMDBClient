package app.practice.practicecleanarchitecturetmdbclient.data.repository.tvshow

import app.practice.practicecleanarchitecturetmdbclient.data.database.TvShowDao
import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShow
import javax.inject.Inject

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}

class TvShowLocalDataSourceImpl @Inject constructor(
    private val tvShowDao: TvShowDao
) :TvShowLocalDataSource{

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        tvShowDao.saveTvShows(tvShows)
    }

    override suspend fun clearAll() {
        tvShowDao.deleteAllTvShows()
    }

}