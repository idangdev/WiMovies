package com.wildan.wimovies.ui.Bookmark.tvshowbookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.TvShowEntity

class TvShowBookmarkViewModel (private val wiMoviesRepository: WiMoviesRepository): ViewModel(){

    fun getTvShowBookmark(): LiveData<PagedList<TvShowEntity>> = wiMoviesRepository.getBookmarkedTvShow()

}