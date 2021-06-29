package app.practice.practicecleanarchitecturetmdbclient.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.practice.practicecleanarchitecturetmdbclient.data.model.artist.Artist
import app.practice.practicecleanarchitecturetmdbclient.data.model.movie.Movie
import app.practice.practicecleanarchitecturetmdbclient.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

}