package com.wildan.wimovies.ui.Bookmark.tvshowbookmark

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildan.wimovies.R
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.databinding.MoviesItemListBinding
import com.wildan.wimovies.databinding.TvshowItemListBinding
import com.wildan.wimovies.ui.detail.movies.DetailMoviesActivity
import com.wildan.wimovies.ui.detail.tvshow.DetailTvShowActivity

class TvShowBookmarkAdapter: PagedListAdapter<TvShowEntity, TvShowBookmarkAdapter.TvShowBookmarkViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>(){
            override fun areItemsTheSame(oldTvShowBookmark: TvShowEntity, newTvShowBookmark: TvShowEntity): Boolean {
                return oldTvShowBookmark.tvShowId == newTvShowBookmark.tvShowId
            }

            override fun areContentsTheSame(oldTvShowBookmark: TvShowEntity, newTvShowBookmark: TvShowEntity): Boolean {
                return oldTvShowBookmark == newTvShowBookmark
            }

        }
    }

    inner class TvShowBookmarkViewHolder(val binding: TvshowItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowBookmarkViewHolder {
        val binding = TvshowItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowBookmarkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowBookmarkViewHolder, position: Int) {
        val tvShowBookmark = getItem(position)
        if (tvShowBookmark != null){
            Glide.with(holder.itemView.context)
                .load(tvShowBookmark.tvShowPoster)
                .into(holder.binding.ivPosterTvshow)
            holder.binding.tvTvshowTitle.text = tvShowBookmark.tvShowTitle
            holder.binding.tvGenreTvshow.text = holder.itemView.resources.getString(R.string.tvshow_genre, tvShowBookmark.tvShowGenre)
            holder.binding.tvRatingTvshow.text = holder.itemView.resources.getString(R.string.tvshow_rating, tvShowBookmark.tvShowRating )

            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailTvShowActivity::class.java)
                intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShowBookmark.tvShowId)
                holder.itemView.context.startActivity(intent)
            }
        }

    }
}