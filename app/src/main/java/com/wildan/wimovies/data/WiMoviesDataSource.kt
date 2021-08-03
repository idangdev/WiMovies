package com.wildan.wimovies.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.vo.Resource

interface WiMoviesDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MoviesEntity>>>

    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getMoviesDetail(moviesId: String): LiveData<Resource<MoviesEntity>>

    fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShowEntity>>

    fun getBookmarkedMovies(): LiveData<PagedList<MoviesEntity>>

    fun getBookmarkedTvShow(): LiveData<PagedList<TvShowEntity>>

    fun setMoviesBookmark(movies: MoviesEntity, state: Boolean)

    fun setTvShowBookmark(tvShow: TvShowEntity, state: Boolean)

}