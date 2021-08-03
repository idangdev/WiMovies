package com.wildan.wimovies.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.vo.Resource

class TvShowViewModel(private val wiMoviesRepository: WiMoviesRepository): ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = wiMoviesRepository.getAllTvShow()

}