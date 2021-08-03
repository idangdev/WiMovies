package com.wildan.wimovies.di

import android.content.Context
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.LocalDataSource
import com.wildan.wimovies.data.source.local.room.WiMoviesDatabase
import com.wildan.wimovies.data.source.remote.RemoteDataSource
import com.wildan.wimovies.utils.AppExecutors
import com.wildan.wimovies.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): WiMoviesRepository {
        val databaseWiMovies = WiMoviesDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(databaseWiMovies.wiMoviesDao())
        val appExecutors = AppExecutors()

        return WiMoviesRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}