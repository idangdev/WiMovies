package com.wildan.wimovies.ui.Bookmark.moviesbookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.wimovies.R
import com.wildan.wimovies.databinding.FragmentMoviesBookmarkBinding
import com.wildan.wimovies.viewmodel.ViewModelFactory

class MoviesBookmarkFragment : Fragment() {

    private lateinit var fragmentMoviesBookmarkBinding: FragmentMoviesBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentMoviesBookmarkBinding = FragmentMoviesBookmarkBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesBookmarkViewModel::class.java]

            val adapter = MoviesBookmarkAdapter()

            fragmentMoviesBookmarkBinding.progressBarMvb.visibility = View.VISIBLE
            viewModel.getMoviesBookmarks().observe(this, { moviesBookmark ->
                fragmentMoviesBookmarkBinding.progressBarMvb.visibility = View.GONE
                adapter.submitList(moviesBookmark)
                adapter.notifyDataSetChanged()
            })

            with(fragmentMoviesBookmarkBinding.rvMoviesBookmark){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }

        }
    }


}