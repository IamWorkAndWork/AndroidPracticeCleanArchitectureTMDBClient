package app.practice.practicecleanarchitecturetmdbclient.data.repository.tvshow

import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShows: List<TvShow>)
}

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = arrayListOf<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }

}