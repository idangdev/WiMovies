package com.wildan.wimovies.ui.home

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wildan.wimovies.ui.movies.MoviesFragment
import com.wildan.wimovies.ui.tvshow.TvShowFragment

class SectionsPagerAdapter (activity: AppCompatActivity): FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = MoviesFragment()
            1 -> fragment = TvShowFragment()
        }
        return fragment as Fragment
    }

}