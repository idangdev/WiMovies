package com.wildan.wimovies.ui.Bookmark.moviesbookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.nhaarman.mockitokotlin2.verify
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.utils.DataExample
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class MoviesBookmarkViewModelTest{
    private lateinit var viewModel: MoviesBookmarkViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var wiMoviesRepository: WiMoviesRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MoviesEntity>>

    @Before
    fun setUp(){
        viewModel = MoviesBookmarkViewModel(wiMoviesRepository)
    }

    @Test
    fun `getMoviesBookmark harus sukses`() {
        val exp = MutableLiveData<PagedList<MoviesEntity>>()
        exp.value = PagedTestDataSources.snapshot(DataExample.generateMoviesExample())

        `when`(wiMoviesRepository.getBookmarkedMovies()).thenReturn(exp)

        viewModel.getMoviesBookmarks().observeForever(observer)
        verify(observer).onChanged(exp.value)

        val valueExp = exp.value
        val valueAct = viewModel.getMoviesBookmarks().value
        assertEquals(valueExp, valueAct)
        assertEquals(valueAct?.snapshot(), valueAct?.snapshot())
        assertEquals(valueExp?.size, valueAct?.size)
    }

    @Test
    fun `getMoviesBookmark harus sukses tapi data kosong`(){
        val exp = MutableLiveData<PagedList<MoviesEntity>>()
        exp.value = PagedTestDataSources.snapshot()

        `when`(wiMoviesRepository.getBookmarkedMovies()).thenReturn(exp)

        viewModel.getMoviesBookmarks().observeForever(observer)
        verify(observer).onChanged(exp.value)

        val valueActDataSize = viewModel.getMoviesBookmarks().value?.size
        Assert.assertTrue("size of data should be 0, actual is $valueActDataSize", valueActDataSize == 0)
    }

    class PagedTestDataSources private constructor(private val items: List<MoviesEntity>): PositionalDataSource<MoviesEntity>() {
        companion object {
            fun snapshot(items: List<MoviesEntity> = listOf()): PagedList<MoviesEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<MoviesEntity>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MoviesEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}