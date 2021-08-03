package com.wildan.wimovies.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.data.source.local.entity.TvShowEntity

@Dao
interface WiMoviesDao {

    // Movies

    @Query("SELECT * FROM moviesentities")
    fun getMovies(): DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM moviesentities WHERE moviesBookmarked = 1")
    fun getBookmarkedMovies(): DataSource.Factory<Int, MoviesEntity>

    @Transaction
    @Query("SELECT * FROM moviesentities WHERE moviesId = :moviesId")
    fun getMoviesDetail(moviesId: String): LiveData<MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MoviesEntity>)

    @Update
    fun updateMovies(movies: MoviesEntity)

    // Tv Show

    @Query("SELECT * FROM tvshowentities")
    fun getTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvshowentities WHERE tvShowBookmarked = 1")
    fun getBookmarkedTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
    fun getTvShowDetail(tvShowId: String): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)

}