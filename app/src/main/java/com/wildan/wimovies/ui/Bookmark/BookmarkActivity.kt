package com.wildan.wimovies.ui.Bookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayoutMediator
import com.wildan.wimovies.R
import com.wildan.wimovies.databinding.ActivityBookmarkBinding

class BookmarkActivity : AppCompatActivity() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_movies,
            R.string.tab_tvshow
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapterBookmark = SectionPagerAdapterBookmark(this)
        binding.viewPagerBookmark.adapter = sectionPagerAdapterBookmark
        TabLayoutMediator(binding.tabsBookmark, binding.viewPagerBookmark) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }
}