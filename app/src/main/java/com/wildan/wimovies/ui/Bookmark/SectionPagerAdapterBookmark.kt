package com.wildan.wimovies.ui.Bookmark

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wildan.wimovies.ui.Bookmark.moviesbookmark.MoviesBookmarkFragment
import com.wildan.wimovies.ui.Bookmark.tvshowbookmark.TvShowBookmarkFragment

class SectionPagerAdapterBookmark(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = MoviesBookmarkFragment()
            1 -> fragment = TvShowBookmarkFragment()
        }
        return fragment as Fragment
    }
}