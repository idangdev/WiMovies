package com.wildan.wimovies.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wildan.wimovies.R
import com.wildan.wimovies.databinding.FragmentTvShowBinding
import com.wildan.wimovies.ui.movies.MoviesAdapter
import com.wildan.wimovies.ui.movies.MoviesViewModel
import com.wildan.wimovies.viewmodel.ViewModelFactory
import com.wildan.wimovies.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory).get(
                TvShowViewModel::class.java)

            val tvShowAdapter = TvShowAdapter()

            viewModel.getTvShow().observe(this, { tvShow ->
                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> fragmentTvShowBinding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentTvShowBinding?.progressBar?.visibility = View.GONE
                            tvShowAdapter.submitList(tvShow.data)
                            tvShowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            fragmentTvShowBinding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Maaf, Ada Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvShowBinding?.rvTvshow) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = tvShowAdapter
            }

        }
    }

}