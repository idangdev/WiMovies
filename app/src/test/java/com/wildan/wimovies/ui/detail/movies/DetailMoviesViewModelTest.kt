package com.wildan.wimovies.ui.detail.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
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
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMoviesViewModelTest {
    private lateinit var viewModel: DetailMoviesViewModel
    private val exampleMovies = DataExample.generateMoviesExample()[0]
    private val moviesId = exampleMovies.moviesId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var wiMoviesRepository: WiMoviesRepository

    @Mock
    private lateinit var moviesObserver: Observer<Resource<MoviesEntity>>

    @Before
    fun setup() {
        viewModel = DetailMoviesViewModel(wiMoviesRepository)
        viewModel.setSelectedMovies(moviesId)
    }

    @Test
    fun getMovies() {
        val exampleMovies = Resource.success(DataExample.generateDummyMoviesDetailBookmarked(exampleMovies, true))
        val movies = MutableLiveData<Resource<MoviesEntity>>()

        movies.value = exampleMovies

        `when`(wiMoviesRepository.getMoviesDetail(moviesId)).thenReturn(movies)
        viewModel.getMovies.observeForever(moviesObserver)
        verify(moviesObserver).onChanged(exampleMovies)
    }

    @Test
    fun setBookmarkMovies(){
        val exp = MutableLiveData<Resource<MoviesEntity>>()
        exp.value = Resource.success(DataExample.generateDummyMoviesDetailBookmarked(exampleMovies, true))

        `when`(wiMoviesRepository.getMoviesDetail(moviesId)).thenReturn(exp)

        viewModel.setBookmark()
        viewModel.getMovies.observeForever(moviesObserver)

        verify(moviesObserver).onChanged(exp.value)

        val valueExp = exp.value
        val valueAct = viewModel.getMovies.value

        assertEquals(valueExp, valueAct)
    }
}