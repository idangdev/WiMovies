package com.wildan.wimovies.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.wildan.wimovies.R
import com.wildan.wimovies.utils.DataExample
import com.wildan.wimovies.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{

    private val exampleMovies = DataExample.generateMoviesExample()
    private val exampleTvShow = DataExample.generateTvShowExample()

    @Before
    fun setUp(){
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(exampleMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_desc)).check(matches(withText(exampleMovies[0].moviesTitle)))
        onView(withId(R.id.tv_genre_desc)).check(matches(withText("Genre: ${exampleMovies[0].moviesGenre}")))
        onView(withId(R.id.tv_rating_desc)).check(matches(withText("Rating: ${exampleMovies[0].moviesRating}")))
        onView(withId(R.id.tv_description_desc)).check(matches(withText(exampleMovies[0].moviesDescription)))
    }

    @Test
    fun loadTvShow(){
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(exampleTvShow.size))
    }

    @Test
    fun loadDetailTvShow(){
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_desc)).check(matches(withText(exampleTvShow[0].tvShowTitle)))
        onView(withId(R.id.tv_genre_desc)).check(matches(withText("Genre: ${exampleTvShow[0].tvShowGenre}")))
        onView(withId(R.id.tv_rating_desc)).check(matches(withText("Rating: ${exampleTvShow[0].tvShowRating}")))
        onView(withId(R.id.tv_description_desc)).check(matches(withText(exampleTvShow[0].tvShowDescription)))
    }

    @Test
    fun loadMoviesBookmark(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.menu_bookmark)).perform(click())
        onView(withId(R.id.rv_movies_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies_bookmark)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_desc)).check(matches(withText(exampleMovies[0].moviesTitle)))
        onView(withId(R.id.tv_genre_desc)).check(matches(withText("Genre: ${exampleMovies[0].moviesGenre}")))
        onView(withId(R.id.tv_rating_desc)).check(matches(withText("Rating: ${exampleMovies[0].moviesRating}")))
        onView(withId(R.id.tv_description_desc)).check(matches(withText(exampleMovies[0].moviesDescription)))
        onView(withId(R.id.btn_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

    }

    @Test
    fun loadTvShowBookmark(){
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.menu_bookmark)).perform(click())
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow_bookmark)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_desc)).check(matches(withText(exampleTvShow[0].tvShowTitle)))
        onView(withId(R.id.tv_genre_desc)).check(matches(withText("Genre: ${exampleTvShow[0].tvShowGenre}")))
        onView(withId(R.id.tv_rating_desc)).check(matches(withText("Rating: ${exampleTvShow[0].tvShowRating}")))
        onView(withId(R.id.tv_description_desc)).check(matches(withText(exampleTvShow[0].tvShowDescription)))
        onView(withId(R.id.btn_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

    }
}