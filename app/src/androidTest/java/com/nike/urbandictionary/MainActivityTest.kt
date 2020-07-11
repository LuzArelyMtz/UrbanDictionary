package com.nike.urbandictionary

import android.view.KeyEvent
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nike.urbandictionary.view.MainActivity
import org.junit.Rule
import androidx.test.rule.ActivityTestRule
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun `Succesfylly_filled_recyclerview_when_a_definition_is_searched`() {
        val searchButton = Espresso.onView(
            withId(R.id.menu_search)
        )
        val mainRecyclerView = Espresso.onView(withId(R.id.rvDefinition))

        searchButton.perform(click())
        onView(isAssignableFrom(AutoCompleteTextView::class.java))
            .perform(typeText("house")).perform(pressKey(KeyEvent.KEYCODE_ENTER))

        Thread.sleep(1000)

        mainRecyclerView.check { view, noViewFoundException ->
            noViewFoundException?.apply {
                throw this
            }
            Assert.assertTrue(
                view is RecyclerView &&
                        view.adapter != null && view.adapter?.itemCount ?: -1 > 0
            )

        }
    }
}