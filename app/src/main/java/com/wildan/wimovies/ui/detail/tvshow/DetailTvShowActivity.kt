package com.wildan.wimovies.ui.detail.tvshow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.wildan.wimovies.R
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.databinding.ActivityDetailTvShowBinding
import com.wildan.wimovies.viewmodel.ViewModelFactory
import com.wildan.wimovies.vo.Status

class DetailTvShowActivity : AppCompatActivity() {

    companion object{
        val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding

    private lateinit var viewModel: DetailTvShowViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(activityDetailTvShowBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory).get(
            DetailTvShowViewModel::class.java)

        val extras = intent.extras
        if(extras != null) {
            val tvShowId = extras.getString(EXTRA_TVSHOW)
            if (tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)


                viewModel.getTvShow.observe(this, { tvShowDetail ->
                    if (tvShowDetail != null){
                        when(tvShowDetail.status) {
                            Status.LOADING -> {
                                Log.d("tvShowDetail", tvShowDetail.toString())
                                activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
                            }
                            Status.SUCCESS -> if(tvShowDetail.data != null){
                                Log.d("tvShowDetail", tvShowDetail.toString())
                                activityDetailTvShowBinding.progressBar.visibility = View.GONE
                                populateTvShow(tvShowDetail.data)
                            }
                            Status.ERROR -> {
                                Log.d("tvShowDetail", tvShowDetail.toString())
                                activityDetailTvShowBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Maaf ada error", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }
    }

    private fun populateTvShow(tvShow: TvShowEntity) {
        Glide.with(this)
            .load(tvShow.tvShowPoster)
            .into(activityDetailTvShowBinding.ivPosterDesc)

        supportActionBar?.title = tvShow.tvShowTitle
        activityDetailTvShowBinding.tvTitleDesc.text = tvShow.tvShowTitle
        activityDetailTvShowBinding.tvGenreDesc.text = getString(R.string.tvshow_genre, tvShow.tvShowGenre)
        activityDetailTvShowBinding.tvRatingDesc.text = getString(R.string.tvshow_rating, tvShow.tvShowRating)
        activityDetailTvShowBinding.tvDescriptionDesc.text = tvShow.tvShowDescription
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.getTvShow.observe(this, { tvShowDetail ->
            if (tvShowDetail != null){
                when (tvShowDetail.status){
                    Status.LOADING -> activityDetailTvShowBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (tvShowDetail.data != null){
                        activityDetailTvShowBinding.progressBar.visibility = View.GONE
                        val state = tvShowDetail.data.tvShowBookmarked
                        setBookmarkState(state)
                    }
                    Status.ERROR -> {
                        activityDetailTvShowBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Maaf ada error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.btn_bookmark -> {
                viewModel.setBookmark()
                return true
            }
            R.id.btn_share -> {
                val text = "You can watch ${activityDetailTvShowBinding.tvTitleDesc.text.toString()} in Wi Movies App"
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(shareIntent,"Share via"))

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.btn_bookmark)
        if (state){
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_after)
        }else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark_before)
        }
    }
}