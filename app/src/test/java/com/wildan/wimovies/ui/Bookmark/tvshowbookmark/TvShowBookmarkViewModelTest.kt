package com.wildan.wimovies.ui.Bookmark.tvshowbookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.nhaarman.mockitokotlin2.verify
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
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
class TvShowBookmarkViewModelTest {
    private lateinit var viewModel: TvShowBookmarkViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var wiMoviesRepository: WiMoviesRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>


    @Before
    fun setUp(){
        viewModel = TvShowBookmarkViewModel(wiMoviesRepository)
    }

    @Test
    fun `getTvShowBookmark harus sukses`() {
        val exp = MutableLiveData<PagedList<TvShowEntity>>()
        exp.value = PagedTestDataSources.snapshot(DataExample.generateTvShowExample())

        `when`(wiMoviesRepository.getBookmarkedTvShow()).thenReturn(exp)

        viewModel.getTvShowBookmark().observeForever(observer)
        verify(observer).onChanged(exp.value)

        val valueExp = exp.value
        val valueAct = viewModel.getTvShowBookmark().value
        assertEquals(valueExp, valueAct)
        assertEquals(valueExp?.snapshot(), valueAct?.snapshot())
        assertEquals(valueExp?.size, valueAct?.size)


    }

    @Test
    fun `getTvShowBookmark harus sukses tapi data kosong`(){
        val exp = MutableLiveData<PagedList<TvShowEntity>>()
        exp.value = PagedTestDataSources.snapshot()

        `when`(wiMoviesRepository.getBookmarkedTvShow()).thenReturn(exp)

        viewModel.getTvShowBookmark().observeForever(observer)
        verify(observer).onChanged(exp.value)

        val valueActDataSize = viewModel.getTvShowBookmark().value?.size
        Assert.assertTrue("besar data harus 0, aktualnya $valueActDataSize", valueActDataSize == 0)
    }

    class PagedTestDataSources private constructor(private val items: List<TvShowEntity>): PositionalDataSource<TvShowEntity>() {
        companion object {
            fun snapshot(items: List<TvShowEntity> = listOf()): PagedList<TvShowEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<TvShowEntity>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<TvShowEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }
}