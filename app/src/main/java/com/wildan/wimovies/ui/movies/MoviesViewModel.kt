package com.wildan.wimovies.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.vo.Resource

class MoviesViewModel(private val wiMoviesRepository: WiMoviesRepository): ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MoviesEntity>>> = wiMoviesRepository.getAllMovies()

}