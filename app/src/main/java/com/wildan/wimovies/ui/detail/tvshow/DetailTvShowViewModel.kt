package com.wildan.wimovies.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.wildan.wimovies.data.WiMoviesRepository
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.vo.Resource

class DetailTvShowViewModel(private val wiMoviesRepository: WiMoviesRepository): ViewModel() {

    val tvShowId = MutableLiveData<String>()

    fun setSelectedTvShow(tvShowId: String){
        this.tvShowId.value = tvShowId
    }

//    fun getTvShow(): TvShowEntity {
//        lateinit var tvShow: TvShowEntity
//        var tvShowEntities = DataExample.generateTvShowExample()
//        for (tvShowEntity in tvShowEntities) {
//            if (tvShowEntity.tvId == tvShowId){
//                tvShow = tvShowEntity
//            }
//        }
//        return tvShow
//    }

    var getTvShow : LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId) { mTvShowId ->
        wiMoviesRepository.getTvShowDetail(mTvShowId)
    }

    fun setBookmark() {
        val tvShowResource = getTvShow.value
        if (tvShowResource != null){
            val dataTvShow = tvShowResource.data
            if (dataTvShow != null){
                val newState = !dataTvShow.tvShowBookmarked
                wiMoviesRepository.setTvShowBookmark(dataTvShow, newState)
            }
        }
    }
}