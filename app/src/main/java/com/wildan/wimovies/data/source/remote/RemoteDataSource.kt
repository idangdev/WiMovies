package com.wildan.wimovies.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.utils.EspressoIdlingResource
import com.wildan.wimovies.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MoviesEntity>>>{
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MoviesEntity>>>()
        handler.postDelayed({
            resultMovies.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovies
    }

    fun getAllTvShow(): LiveData<ApiResponse<List<TvShowEntity>>>{
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowEntity>>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShow())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }

    fun getMoviesDetail(moviesId: String): LiveData<ApiResponse<MoviesEntity>>{
        val result = MutableLiveData<ApiResponse<MoviesEntity>>()
        result.value = ApiResponse.success(jsonHelper.loadMoviesDetail(moviesId))
        return result
    }

    fun getTvShowDetail(tvShowId: String): LiveData<ApiResponse<TvShowEntity>>{
        val result = MutableLiveData<ApiResponse<TvShowEntity>>()
        result.value = ApiResponse.success(jsonHelper.loadTvShowDetail(tvShowId))
        return result
    }

//    interface LoadMoviesCallback {
//        fun onAllMoviesReceived(movieResponse: List<MovieResponse>)
//    }
//
//    interface LoadTvShowCallback {
//        fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>)
//    }

}