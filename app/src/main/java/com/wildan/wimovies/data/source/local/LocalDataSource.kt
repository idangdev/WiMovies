package com.wildan.wimovies.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.data.source.local.room.WiMoviesDao

class LocalDataSource private constructor(private val mWiMoviesDao: WiMoviesDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(wiMoviesDao: WiMoviesDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(wiMoviesDao)
    }

    // Movies

    fun getAllMovies(): DataSource.Factory<Int, MoviesEntity> = mWiMoviesDao.getMovies()
    fun getBookmarkedMovies(): DataSource.Factory<Int, MoviesEntity> = mWiMoviesDao.getBookmarkedMovies()
    fun getMoviesDetail(moviesId: String): LiveData<MoviesEntity> =
        mWiMoviesDao.getMoviesDetail(moviesId)
    fun insertMovies(movies: List<MoviesEntity>) = mWiMoviesDao.insertMovies(movies)
    fun setMoviesBookmark(movies: MoviesEntity, newState: Boolean){
        movies.moviesBookmarked = newState
        mWiMoviesDao.updateMovies(movies)
    }
    fun updateMovies(movies: MoviesEntity, moviesId: String) = mWiMoviesDao.updateMovies(movies)

    // Tv Show

    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntity> = mWiMoviesDao.getTvShow()
    fun getBookmarkedTvShow(): DataSource.Factory<Int, TvShowEntity> = mWiMoviesDao.getBookmarkedTvShow()

    fun getTvShowDetail(tvShowId: String): LiveData<TvShowEntity> =
        mWiMoviesDao.getTvShowDetail(tvShowId)

    fun insertTvShow(tvShow: List<TvShowEntity>) = mWiMoviesDao.insertTvShow(tvShow)

    fun setTvShowBookmark(tvShow: TvShowEntity, newState: Boolean){
        tvShow.tvShowBookmarked = newState
        mWiMoviesDao.updateTvShow(tvShow)
    }

    fun updateTvShow(tvShow: TvShowEntity, tvShowId: String) = mWiMoviesDao.updateTvShow(tvShow)

}