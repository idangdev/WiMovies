package com.wildan.wimovies.ui.Bookmark.moviesbookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.MoviesEntity

class MoviesBookmarkViewModel(private val wiMoviesRepository: WiMoviesRepository): ViewModel() {

    fun getMoviesBookmarks(): LiveData<PagedList<MoviesEntity>> = wiMoviesRepository.getBookmarkedMovies()

}