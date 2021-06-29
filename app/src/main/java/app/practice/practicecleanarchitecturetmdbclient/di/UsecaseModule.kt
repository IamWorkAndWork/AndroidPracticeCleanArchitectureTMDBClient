package app.practice.practicecleanarchitecturetmdbclient.di

import app.practice.practicecleanarchitecturetmdbclient.data.repository.artist.ArtistRepository
import app.practice.practicecleanarchitecturetmdbclient.data.repository.movie.MovieRepository
import app.practice.practicecleanarchitecturetmdbclient.data.repository.tvshow.TvShowRepository
import app.practice.practicecleanarchitecturetmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Singleton
    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCaseImpl(
            artistRepository = artistRepository
        )
    }

    @Singleton
    @Provides
    fun provideGetMoviesUseCaseImpl(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCaseImpl(movieRepository = movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCaseImpl(tvShowRepository = tvShowRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCaseImpl(artistRepository = artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateMoviesUsecase(movieRepository: MovieRepository): UpdateMoviesUsecase {
        return UpdateMoviesUsecaseImpl(movieRepository = movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCaseImpl(tvShowRepository = tvShowRepository)
    }

}