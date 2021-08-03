package com.wildan.wimovies.ui.detail.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.vo.Resource

class DetailMoviesViewModel(private val wiMoviesRepository: WiMoviesRepository) : ViewModel(){

//    private lateinit var moviesId: String

    val moviesId = MutableLiveData<String>()

    fun setSelectedMovies(moviesId: String){
        this.moviesId.value = moviesId
    }

//    fun getMovies(): MoviesEntity {
//        lateinit var movies: MoviesEntity
//        var moviesEntities = DataExample.generateMoviesExample()
//        for (moviesEntity in moviesEntities) {
//            if (moviesEntity.moviesId == moviesId){
//                movies = moviesEntity
//            }
//        }
//        return movies
//    }

    var getMovies : LiveData<Resource<MoviesEntity>> = Transformations.switchMap(moviesId) { mMoviesId ->
        wiMoviesRepository.getMoviesDetail(mMoviesId)
    }

    fun setBookmark() {
        val movieResource = getMovies.value
        if (movieResource != null){
            val dataMovie = movieResource.data
            if (dataMovie != null){
                val newState = !dataMovie.moviesBookmarked
                wiMoviesRepository.setMoviesBookmark(dataMovie, newState)
            }
        }
    }

}