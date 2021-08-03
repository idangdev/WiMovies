package com.wildan.wimovies.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
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
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var wiMoviesRepository: WiMoviesRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setup(){
        viewModel = TvShowViewModel(wiMoviesRepository)
    }

    @Test
    fun getTvShow() {
        val exampleTvShow = Resource.success(pagedList)
        `when`(exampleTvShow.data?.size).thenReturn(10)

        val tvShow = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShow.value = exampleTvShow

        Mockito.`when`(wiMoviesRepository.getAllTvShow())
            .thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShow().value?.data
        Mockito.verify(wiMoviesRepository).getAllTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(exampleTvShow)
    }
}