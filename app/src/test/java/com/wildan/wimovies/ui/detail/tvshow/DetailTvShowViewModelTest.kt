package com.wildan.wimovies.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.utils.DataExample
import com.wildan.wimovies.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val exampleTvShow = DataExample.generateTvShowExample()[0]
    private val tvShowId = exampleTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var wiMoviesRepository: WiMoviesRepository

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setup(){
        viewModel = DetailTvShowViewModel(wiMoviesRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShow() {
        val exampleTvShow = Resource.success(DataExample.generateDummyTvShowDetailBookmarked(exampleTvShow, true))
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()

        tvShow.value = exampleTvShow

        `when`(wiMoviesRepository.getTvShowDetail(tvShowId)).thenReturn(tvShow)

        viewModel.getTvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(exampleTvShow)
    }

    @Test
    fun setBookmarkTvShow(){
        val exp = MutableLiveData<Resource<TvShowEntity>>()
        exp.value = Resource.success(DataExample.generateDummyTvShowDetailBookmarked(exampleTvShow, true))

        `when`(wiMoviesRepository.getTvShowDetail(tvShowId)).thenReturn(exp)

        viewModel.setBookmark()
        viewModel.getTvShow.observeForever(tvShowObserver)

        verify(tvShowObserver).onChanged(exp.value)

        val valueExp = exp.value
        val valueAct = viewModel.getTvShow.value

        assertEquals(valueExp, valueAct)
    }
}