package app.practice.practicecleanarchitecturetmdbclient.di

import app.practice.practicecleanarchitecturetmdbclient.data.api.TMDBService
import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShow
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.ArtistRepository
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.ArtistRepositoryImpl
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import app.practice.practicecleanarchitecturetmdbclient.data.repository.movie.*
import app.practice.practicecleanarchitecturetmdbclient.data.repository.tvshow.*
import app.practice.practicecleanarchitecturetmdbclient.utils.Constans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDatasource: ArtistRemoteDatasource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistCacheDataSource = artistCacheDataSource,
            artistLocalDataSource = artistLocalDataSource,
            artistRemoteDatasource = artistRemoteDatasource,
        )
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDatasource: MovieRemoteDatasource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieCacheDataSource = movieCacheDataSource,
            movieLocalDataSource = movieLocalDataSource,
            movieRemoteDatasource = movieRemoteDatasource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowRemoteDataSource: TvShowRemoteDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowCacheDataSource = tvShowCacheDataSource,
            tvShowLocalDataSource = tvShowLocalDataSource,
            tvShowRemoteDataSource = tvShowRemoteDataSource,
        )
    }

}