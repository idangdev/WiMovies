package com.wildan.wimovies.ui.Bookmark.moviesbookmark

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

class MoviesBookmarkAdapter: PagedListAdapter<MoviesEntity, MoviesBookmarkAdapter.MoviesBookmarkViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MoviesEntity>(){
            override fun areItemsTheSame(oldMoviesBookmark: MoviesEntity, newMoviesBookmark: MoviesEntity): Boolean {
                return oldMoviesBookmark.moviesId == newMoviesBookmark.moviesId
            }

            override fun areContentsTheSame(oldMoviesBookmark: MoviesEntity, newMoviesBookmark: MoviesEntity): Boolean {
                return oldMoviesBookmark == newMoviesBookmark
            }

        }
    }

    inner class MoviesBookmarkViewHolder(val binding: MoviesItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesBookmarkViewHolder {
        val binding = MoviesItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesBookmarkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesBookmarkViewHolder, position: Int) {
        val moviesBookmark = getItem(position)
        if (moviesBookmark != null){
            Glide.with(holder.itemView.context)
                .load(moviesBookmark.moviesPoster)
                .into(holder.binding.ivPosterMovies)
            holder.binding.tvMoviesTitle.text = moviesBookmark.moviesTitle
            holder.binding.tvGenreMovies.text = holder.itemView.resources.getString(R.string.movies_genre, moviesBookmark.moviesGenre)
            holder.binding.tvRatingMovies.text = holder.itemView.resources.getString(R.string.movies_rating, moviesBookmark.moviesRating )

            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailMoviesActivity::class.java)
                intent.putExtra(DetailMoviesActivity.EXTRA_MOVIES, moviesBookmark.moviesId)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

}