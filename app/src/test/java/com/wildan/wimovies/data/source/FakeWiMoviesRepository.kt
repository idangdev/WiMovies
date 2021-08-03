package com.wildan.wimovies.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wildan.wimovies.data.NetworkBoundResource
import com.wildan.wimovies.data.WiMoviesDataSource
import com.wildan.wimovies.data.source.local.LocalDataSource
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.data.source.remote.ApiResponse
import com.wildan.wimovies.data.source.remote.RemoteDataSource
import com.wildan.wimovies.utils.AppExecutors
import com.wildan.wimovies.vo.Resource

class FakeWiMoviesRepository (private  val remoteDataSource: RemoteDataSource,
                              private val localDataSource: LocalDataSource,
                              private val appExecutors: AppExecutors
): WiMoviesDataSource {

    override fun getAllMovies(): LiveData<Resource<PagedList<MoviesEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MoviesEntity>, List<MoviesEntity>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MoviesEntity>> {
                val configuration = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), configuration).build()
            }


            override fun shouldFetch(data: PagedList<MoviesEntity>?): Boolean =
                data == null || data.isEmpty()


            override fun createCall(): LiveData<ApiResponse<List<MoviesEntity>>> =
                remoteDataSource.getAllMovies()


            override fun saveCallResult(moviesResponses: List<MoviesEntity>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in moviesResponses) {
                    val movies = MoviesEntity(
                        response.moviesId,
                        response.moviesTitle,
                        response.moviesGenre,
                        response.moviesRating,
                        response.moviesDescription,
                        response.moviesPoster,
                        false
                    )

                    movieList.add(movies)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object  : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowEntity>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val configuration = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(), configuration).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowEntity>>> =
                remoteDataSource.getAllTvShow()

            override fun saveCallResult(tvShowResponse: List<TvShowEntity>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvShowResponse) {
                    val tvshow = TvShowEntity(response.tvShowId,
                        response.tvShowTitle,
                        response.tvShowGenre,
                        response.tvShowRating,
                        response.tvShowDescription,
                        response.tvShowPoster,
                        false)

                    tvShowList.add(tvshow)
                }
                localDataSource.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getMoviesDetail(moviesId: String): LiveData<Resource<MoviesEntity>> {
        return object : NetworkBoundResource<MoviesEntity, MoviesEntity>(appExecutors) {
            override fun loadFromDB(): LiveData<MoviesEntity> =
                localDataSource.getMoviesDetail(moviesId)

            override fun shouldFetch(data: MoviesEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<MoviesEntity>> =
                remoteDataSource.getMoviesDetail(moviesId)

            override fun saveCallResult(data: MoviesEntity) =
                localDataSource.updateMovies(data, moviesId)
        }.asLiveData()
    }

    override fun getTvShowDetail(tvShowId: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowEntity>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowDetail(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<TvShowEntity>> =
                remoteDataSource.getTvShowDetail(tvShowId)


            override fun saveCallResult(data: TvShowEntity) =
                localDataSource.updateTvShow(data, tvShowId)

        }.asLiveData()
    }

    override fun getBookmarkedMovies(): LiveData<PagedList<MoviesEntity>> {
        val configuration = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovies(), configuration).build()
    }


    override fun getBookmarkedTvShow(): LiveData<PagedList<TvShowEntity>> {
        val configuration = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedTvShow(), configuration).build()
    }

    override fun setMoviesBookmark(movies: MoviesEntity, state: Boolean) =
        appExecutors.diskIO().execute{ localDataSource.setMoviesBookmark(movies, state) }

    override fun setTvShowBookmark(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute{ localDataSource.setTvShowBookmark(tvShow, state) }
    }

}