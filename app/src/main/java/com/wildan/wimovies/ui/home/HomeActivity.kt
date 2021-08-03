package com.wildan.wimovies.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.wildan.wimovies.R
import com.wildan.wimovies.databinding.HomeMainBinding
import com.wildan.wimovies.ui.Bookmark.BookmarkActivity

class HomeActivity : AppCompatActivity() {

    companion object {
        @StringRes
        private val TAB_TITLE = intArrayOf(
            R.string.tab_movies,
            R.string.tab_tvshow
        )
    }

    private lateinit var homeMainBinding: HomeMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeMainBinding = HomeMainBinding.inflate(layoutInflater)
        setContentView(homeMainBinding.root)

        // Memanggil fungsi setTabLayout
        setTabLayout()
    }

    // Fungsi untuk men set Tab Layout
    fun setTabLayout(){
        val adapterSectionPager = SectionsPagerAdapter(this)
        homeMainBinding.viewPager.adapter = adapterSectionPager
        TabLayoutMediator(homeMainBinding.tabLayout, homeMainBinding.viewPager) { tabs, position ->
            tabs.text = resources.getString(TAB_TITLE[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_bookmark -> {
                val intent = Intent(this, BookmarkActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return true
        }
    }


}