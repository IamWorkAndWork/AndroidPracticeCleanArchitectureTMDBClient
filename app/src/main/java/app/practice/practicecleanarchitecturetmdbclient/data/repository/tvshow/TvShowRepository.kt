package app.practice.practicecleanarchitecturetmdbclient.data.repository.tvshow

import android.util.Log
import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShow
import javax.inject.Inject

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>
    suspend fun updateTvShows(): List<TvShow>
}

class TvShowRepositoryImpl @Inject constructor(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {

    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        var tvShowList = mutableListOf<TvShow>()
        try {
            tvShowList.addAll(tvShowCacheDataSource.getTvShowFromCache())
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList.addAll(getTvShowsFromDB())
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromDB(): List<TvShow> {
        val tvShowList = mutableListOf<TvShow>()
        try {
            tvShowList.addAll(tvShowLocalDataSource.getTvShowsFromDB())
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList.addAll(getTvShowFromAPI())
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getTvShowFromAPI(): List<TvShow> {
        val tvShowList = mutableListOf<TvShow>()
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList.addAll(body.tvShows)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

}