package com.wildan.wimovies.ui.Bookmark.tvshowbookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.wimovies.R
import com.wildan.wimovies.databinding.FragmentTvShowBookmarkBinding
import com.wildan.wimovies.viewmodel.ViewModelFactory

class TvShowBookmarkFragment : Fragment() {

    private lateinit var fragmentTvShowBookmarkBinding: FragmentTvShowBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentTvShowBookmarkBinding  = FragmentTvShowBookmarkBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowBookmarkViewModel::class.java]

            val adapter = TvShowBookmarkAdapter()

            fragmentTvShowBookmarkBinding.progressBarTsb.visibility = View.VISIBLE
            viewModel.getTvShowBookmark().observe(this, { tvShowBookmark ->
                fragmentTvShowBookmarkBinding.progressBarTsb.visibility = View.GONE
                adapter.submitList(tvShowBookmark)
                adapter.notifyDataSetChanged()
            })

            with(fragmentTvShowBookmarkBinding.rvTvshowBookmark){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
}