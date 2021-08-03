package com.wildan.wimovies.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.utils.DataExample
import com.wildan.wimovies.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var wiMoviesRepository: WiMoviesRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MoviesEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MoviesEntity>

    @Before
    fun setup(){
        viewModel = MoviesViewModel(wiMoviesRepository)
    }

    @Test
    fun getMovies() {
        val exampleMovies = Resource.success(pagedList)
        `when`(exampleMovies.data?.size).thenReturn(10)

        val movies = MutableLiveData<Resource<PagedList<MoviesEntity>>>()
        movies.value = exampleMovies

        `when`(wiMoviesRepository.getAllMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getMovies().value?.data
        verify(wiMoviesRepository).getAllMovies()
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(exampleMovies)
    }
}