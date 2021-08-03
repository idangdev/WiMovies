package com.wildan.wimovies.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildan.wimovies.R
import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.databinding.MoviesItemListBinding
import com.wildan.wimovies.ui.detail.movies.DetailMoviesActivity

class MoviesAdapter: PagedListAdapter<MoviesEntity, MoviesAdapter.MoviesViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MoviesEntity>(){
            override fun areItemsTheSame(oldMovies: MoviesEntity, newMovies: MoviesEntity): Boolean {
                return oldMovies.moviesId == newMovies.moviesId
            }

            override fun areContentsTheSame(oldMovies: MoviesEntity, newMovies: MoviesEntity): Boolean {
                return oldMovies == newMovies
            }

        }
    }

    inner class MoviesViewHolder(val binding: MoviesItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = MoviesItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = getItem(position)

        if (movies != null){
            Glide.with(holder.itemView.context)
                .load(movies.moviesPoster)
                .into(holder.binding.ivPosterMovies)
            holder.binding.tvMoviesTitle.text = movies.moviesTitle
            holder.binding.tvGenreMovies.text = holder.itemView.resources.getString(R.string.movies_genre, movies.moviesGenre)
            holder.binding.tvRatingMovies.text = holder.itemView.resources.getString(R.string.movies_rating, movies.moviesRating )

            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailMoviesActivity::class.java)
                intent.putExtra(DetailMoviesActivity.EXTRA_MOVIES, movies.moviesId)
                holder.itemView.context.startActivity(intent)
            }
        }
    }
}