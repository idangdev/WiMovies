package com.wildan.wimovies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.di.Injection
import com.wildan.wimovies.ui.Bookmark.moviesbookmark.MoviesBookmarkViewModel
import com.wildan.wimovies.ui.Bookmark.tvshowbookmark.TvShowBookmarkViewModel
import com.wildan.wimovies.ui.detail.movies.DetailMoviesViewModel
import com.wildan.wimovies.ui.detail.tvshow.DetailTvShowViewModel
import com.wildan.wimovies.ui.movies.MoviesViewModel
import com.wildan.wimovies.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mWiMoviesRepository: WiMoviesRepository): ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(mWiMoviesRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mWiMoviesRepository) as T
            }
            modelClass.isAssignableFrom(DetailMoviesViewModel::class.java) -> {
                return DetailMoviesViewModel(mWiMoviesRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(mWiMoviesRepository) as T
            }
            modelClass.isAssignableFrom(MoviesBookmarkViewModel::class.java) -> {
                return MoviesBookmarkViewModel(mWiMoviesRepository) as T
            }
            modelClass.isAssignableFrom(TvShowBookmarkViewModel::class.java) -> {
                return TvShowBookmarkViewModel(mWiMoviesRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class: "+ modelClass.name)
        }
    }

}