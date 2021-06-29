package app.practice.practicecleanarchitecturetmdbclient.di

import app.practice.practicecleanarchitecturetmdbclient.data.api.TMDBService
import app.practice.practicecleanarchitecturetmdbclient.data.database.ArtistDao
import app.practice.practicecleanarchitecturetmdbclient.data.database.MovieDao
import app.practice.practicecleanarchitecturetmdbclient.data.database.TvShowDao
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource.*
import app.practice.practicecleanarchitecturetmdbclient.data.repository.movie.*
import app.practice.practicecleanarchitecturetmdbclient.data.repository.tvshow.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatasourceModule {

    @Provides
    @Singleton
    fun provideArtistCacheDataSource(): ArtistCacheDataSourceImpl {
        return ArtistCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao = artistDao)
    }

    @Provides
    @Singleton
    fun provideArtistRemoteDataSource(
        tmdbService: TMDBService,
        @Named("API_KEY") apiKey: String
    ): ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Provides
    @Singleton
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao = movieDao)
    }

    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(
        tmdbService: TMDBService,
        @Named("API_KEY") apiKey: String
    ): MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(tmdbService, apiKey)
    }

    @Provides
    @Singleton
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Provides
    @Singleton
    fun provideTvShowRemoteLocalDataSource(
        tmdbService: TMDBService,
        @Named("API_KEY") apiKey: String
    ): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }


}