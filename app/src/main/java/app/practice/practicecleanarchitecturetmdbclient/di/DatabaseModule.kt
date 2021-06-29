package app.practice.practicecleanarchitecturetmdbclient.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import app.practice.practicecleanarchitecturetmdbclient.data.database.ArtistDao
import app.practice.practicecleanarchitecturetmdbclient.data.database.MovieDao
import app.practice.practicecleanarchitecturetmdbclient.data.database.TMDBDatabase
import app.practice.practicecleanarchitecturetmdbclient.data.database.TvShowDao
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "tmdvclient"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

}