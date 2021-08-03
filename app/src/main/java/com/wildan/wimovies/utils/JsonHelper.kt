package com.wildan.wimovies.utils

import android.content.Context
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingJsonFileToString(jsonFileName: String): String?{
        return try {
            val `is` = context.assets.open(jsonFileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        }catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MoviesEntity> {
        val list = ArrayList<MoviesEntity>()
        try {
            val responseObject = JSONObject(parsingJsonFileToString("MoviesResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movies = listArray.getJSONObject(i)

                val moviesId = movies.getString("moviesId")
                val moviesTitle = movies.getString("moviesTitle")
                val moviesGenre = movies.getString("moviesGenre")
                val moviesRating = movies.getString("moviesRating")
                val moviesDescription = movies.getString("moviesDescription")
                val moviesPoster = movies.getString("moviesPoster")

                val moviesResponse = MoviesEntity(moviesId, moviesTitle, moviesGenre, moviesRating, moviesDescription, moviesPoster)
                list.add(moviesResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShow(): List<TvShowEntity> {
        val list = ArrayList<TvShowEntity>()
        try {
            val responseObject = JSONObject(parsingJsonFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshow")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val tvShowId = tvshow.getString("tvShowId")
                val tvShowTitle = tvshow.getString("tvShowTitle")
                val tvShowGenre = tvshow.getString("tvShowGenre")
                val tvShowRating = tvshow.getString("tvShowRating")
                val tvShowDescription = tvshow.getString("tvShowDescription")
                val tvShowPoster = tvshow.getString("tvShowPoster")

                val tvShowResponse = TvShowEntity(tvShowId, tvShowTitle, tvShowGenre, tvShowRating, tvShowDescription, tvShowPoster)
                list.add(tvShowResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }
        return list
    }

    fun loadMoviesDetail(moviesId: String): MoviesEntity {
        val fileName = String.format("Movies_%s.json", moviesId)
        var movieDetailResponse: MoviesEntity? = null
        try {
            val result = parsingJsonFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)

                val moviesId = responseObject.getString("moviesId")
                val moviesTitle = responseObject.getString("moviesTitle")
                val moviesGenre = responseObject.getString("moviesGenre")
                val moviesRating = responseObject.getString("moviesRating")
                val moviesDescription = responseObject.getString("moviesDescription")
                val moviesPoster = responseObject.getString("moviesPoster")
                movieDetailResponse = MoviesEntity(moviesId, moviesTitle, moviesGenre, moviesRating, moviesDescription, moviesPoster)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }
        return movieDetailResponse as MoviesEntity
    }

    fun loadTvShowDetail(tvShowId: String): TvShowEntity {
        val fileName = String.format("TvShow_%s.json", tvShowId)
        var tvShowDetailResponse: TvShowEntity? = null
        try {
            val result = parsingJsonFileToString(fileName)
            if (result != null){
                val responseObject = JSONObject(result)

                val tvShowId = responseObject.getString("tvShowId")
                val tvShowTitle = responseObject.getString("tvShowTitle")
                val tvShowGenre = responseObject.getString("tvShowGenre")
                val tvShowRating = responseObject.getString("tvShowRating")
                val tvShowDescription = responseObject.getString("tvShowDescription")
                val tvShowPoster = responseObject.getString("tvShowPoster")
                tvShowDetailResponse = TvShowEntity(tvShowId, tvShowTitle, tvShowGenre, tvShowRating, tvShowDescription, tvShowPoster)
            }
        }catch (e: JSONException) {
            e.printStackTrace()
        }
        return tvShowDetailResponse as TvShowEntity
    }



}