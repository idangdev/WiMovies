package com.wildan.wimovies.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.wildan.wimovies.data.source.remote.RemoteDataSource
import com.wildan.wimovies.utils.DataExample
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import com.wildan.wimovies.data.source.local.LocalDataSource
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.utils.AppExecutors
import com.wildan.wimovies.utils.LiveDataTestUtil
import com.wildan.wimovies.utils.PagedListUtil
import com.wildan.wimovies.vo.Resource
import org.junit.Rule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class WiMoviesRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val wiMoviesRepository = FakeWiMoviesRepository(remote, local, appExecutors)

    private val movieResponse = DataExample.generateRemoteDummyMovies()
    private val tvShowResponse = DataExample.generateRemoteDummyTvShow()
    private val movieId = movieResponse[0].moviesId
    private val tvShowId = tvShowResponse[0].tvShowId

    @Test
    fun getAllMovies(){
        val dataSourceFactoryMovies = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactoryMovies)
        wiMoviesRepository.getAllMovies()

        val moviesEntities = Resource.success(PagedListUtil.mockPagedList(DataExample.generateMoviesExample()))
        verify(local).getAllMovies()
        assertNotNull(moviesEntities.data)
        assertEquals(movieResponse.size.toLong(), moviesEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow(){
        val dataSourceFactoryTvShow = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactoryTvShow)
        wiMoviesRepository.getAllTvShow()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataExample.generateTvShowExample()))
        verify(local).getAllTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getMoviesDetail(){
        val dummyMoviesEntity = MutableLiveData<MoviesEntity>()
        dummyMoviesEntity.value = DataExample.generateDummyMoviesDetail(movieId)
        `when`(local.getMoviesDetail(movieId)).thenReturn(dummyMoviesEntity)

        val moviesEntities = LiveDataTestUtil.getValue(wiMoviesRepository.getMoviesDetail(movieId))
        verify(local).getMoviesDetail(movieId)

        assertNotNull(moviesEntities)
        assertNotNull(moviesEntities.data?.moviesTitle)
        assertEquals(movieResponse[0].moviesTitle, moviesEntities.data?.moviesTitle)
    }

    @Test
    fun getTvShowDetail(){
        val dummyTvShowEntity = MutableLiveData<TvShowEntity>()
        dummyTvShowEntity.value = DataExample.generateDummyTvShowDetail(tvShowId)
        `when`(local.getTvShowDetail(tvShowId)).thenReturn(dummyTvShowEntity)

        val tvShowEntities = LiveDataTestUtil.getValue(wiMoviesRepository.getTvShowDetail(tvShowId))
        verify(local).getTvShowDetail(tvShowId)

        assertNotNull(tvShowEntities)
        assertNotNull(tvShowEntities.data?.tvShowTitle)
        assertEquals(tvShowResponse[0].tvShowTitle, tvShowEntities.data?.tvShowTitle)
    }

    @Test
    fun getMoviesBookmark() {
        val dataSourceFactoryMoviesBookmark = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getBookmarkedMovies()).thenReturn(dataSourceFactoryMoviesBookmark)
        wiMoviesRepository.getBookmarkedMovies()

        val moviesEntity = Resource.success(PagedListUtil.mockPagedList(DataExample.generateMoviesExample()))
        verify(local).getBookmarkedMovies()
        assertNotNull(moviesEntity)
        assertEquals(movieResponse.size.toLong(), moviesEntity.data?.size?.toLong())
    }

    @Test
    fun getTvShowBookmark() {
        val dataSourceFactoryTvShowBookmark = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getBookmarkedTvShow()).thenReturn(dataSourceFactoryTvShowBookmark)
        wiMoviesRepository.getBookmarkedTvShow()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataExample.generateTvShowExample()))
        verify(local).getBookmarkedTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntity.data?.size?.toLong())

    }



}