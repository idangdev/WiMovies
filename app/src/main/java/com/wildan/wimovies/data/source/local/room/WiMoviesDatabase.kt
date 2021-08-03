package com.wildan.wimovies.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.data.source.local.entity.TvShowEntity

@Database(entities = [MoviesEntity::class, TvShowEntity::class],
        version = 1,
        exportSchema = false)
abstract class WiMoviesDatabase: RoomDatabase() {
    abstract fun wiMoviesDao(): WiMoviesDao

    companion object{
        @Volatile
        private var INSTANCE: WiMoviesDatabase? = null

        fun getInstance(context: Context): WiMoviesDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    WiMoviesDatabase::class.java,
                    "WiMovies.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }

}