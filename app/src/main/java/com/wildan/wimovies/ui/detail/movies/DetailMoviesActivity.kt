package com.wildan.wimovies.ui.detail.movies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.wildan.wimovies.R
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.databinding.ActivityDetailMoviesBinding
import com.wildan.wimovies.ui.home.HomeActivity
import com.wildan.wimovies.utils.DataExample
import com.wildan.wimovies.viewmodel.ViewModelFactory
import com.wildan.wimovies.vo.Status

class DetailMoviesActivity : AppCompatActivity() {

    companion object{
        val EXTRA_MOVIES = "extra_movies"
    }

    private lateinit var activityDetailMoviesBinding: ActivityDetailMoviesBinding

    private lateinit var viewModel: DetailMoviesViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMoviesBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(activityDetailMoviesBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(DetailMoviesViewModel::class.java)

        val extras = intent.extras
        if (extras!= null) {
            val moviesId = extras.getString(EXTRA_MOVIES)
            if (moviesId != null){
                viewModel.setSelectedMovies(moviesId)

                viewModel.getMovies.observe(this, { moviesDetail ->
                    if (moviesDetail != null) {
                        when(moviesDetail.status) {

                            Status.LOADING -> {
                                Log.d("moviesDetail", moviesDetail.toString())
                                activityDetailMoviesBinding.progressBar.visibility = View.VISIBLE
                            }
                            Status.SUCCESS -> if (moviesDetail.data != null) {
                                Log.d("moviesDetail", moviesDetail.toString())
                                activityDetailMoviesBinding.progressBar.visibility = View.GONE
                                populateMovies(moviesDetail.data)
                            }
                            Status.ERROR -> {
                                Log.d("moviesDetail", moviesDetail.toString())
                                activityDetailMoviesBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Maaf, Ada Error", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateMovies(movies: MoviesEntity) {
        Glide.with(this)
            .load(movies.moviesPoster)
            .into(activityDetailMoviesBinding.ivPosterDesc)

        supportActionBar?.title = movies.moviesTitle
        activityDetailMoviesBinding.tvTitleDesc.text = movies.moviesTitle
        activityDetailMoviesBinding.tvGenreDesc.text = getString(R.string.movies_genre, movies.moviesGenre)
        activityDetailMoviesBinding.tvRatingDesc.text = getString(R.string.movies_rating, movies.moviesRating)
        activityDetailMoviesBinding.tvDescriptionDesc.text = movies.moviesDescription
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.getMovies.observe(this, { moviesDetail ->
            if (moviesDetail != null) {
                when (moviesDetail.status){
                    Status.LOADING -> activityDetailMoviesBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (moviesDetail.data != null){
                        activityDetailMoviesBinding.progressBar.visibility = View.GONE
                        val state = moviesDetail.data.moviesBookmarked
                        setBookmarkState(state)
                    }
                    Status.ERROR -> {
                        activityDetailMoviesBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Maaf ada error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.btn_bookmark -> {
                viewModel.setBookmark()
                return true
            }
            R.id.btn_share -> {
                val text = "You can watch ${activityDetailMoviesBinding.tvTitleDesc.text.toString()} in Wi Movies App"
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(shareIntent,"Share via"))

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean){
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.btn_bookmark)
        if (state){
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_after)
        }else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_before)
        }
    }
}