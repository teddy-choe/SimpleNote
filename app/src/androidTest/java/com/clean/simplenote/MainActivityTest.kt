package com.clean.simplenote

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.clean.simplenote.view.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.nav_main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isFragmentOnBottomNavigationView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.nav_menu)).perform(click())
        onView(withId(R.id.container_menu_fragment)).check(matches(isDisplayed()))
        onView(withId(R.id.nav_search)).perform(click())
        onView(withId(R.id.container_search_fragment)).check(matches(isDisplayed()))
        onView(withId(R.id.nav_edit)).perform(click())
        onView(withId(R.id.container_edit_fragment)).check(matches(isDisplayed()))
        onView(withId(R.id.nav_add)).perform(click())
        onView(withId(R.id.container_add_fragment)).check(matches(isDisplayed()))
    }
}