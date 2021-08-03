package com.wildan.wimovies.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wildan.wimovies.R
import com.wildan.wimovies.data.source.local.entity.TvShowEntity
import com.wildan.wimovies.databinding.TvshowItemListBinding
import com.wildan.wimovies.ui.detail.tvshow.DetailTvShowActivity

class TvShowAdapter: PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>(){
            override fun areItemsTheSame(oldTvShow: TvShowEntity, newTvShow: TvShowEntity): Boolean {
                return oldTvShow.tvShowId == newTvShow.tvShowId
            }

            override fun areContentsTheSame(oldTvShow: TvShowEntity, newTvShow: TvShowEntity): Boolean {
                return  oldTvShow == newTvShow
            }

        }
    }

    inner class TvShowViewHolder(val binding: TvshowItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = TvshowItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null){
            Glide.with(holder.itemView.context)
                .load(tvShow.tvShowPoster)
                .into(holder.binding.ivPosterTvshow)
            holder.binding.tvTvshowTitle.text = tvShow.tvShowTitle
            holder.binding.tvGenreTvshow.text = holder.itemView.resources.getString(R.string.tvshow_genre, tvShow.tvShowGenre)
            holder.binding.tvRatingTvshow.text = holder.itemView.resources.getString(R.string.tvshow_rating, tvShow.tvShowRating )

            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailTvShowActivity::class.java)
                intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShow.tvShowId)
                holder.itemView.context.startActivity(intent)
            }
        }

    }
}