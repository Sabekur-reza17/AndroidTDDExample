package com.sabekur2017.androidtddexample.ui

import com.sabekur2017.androidtddexample.R
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddSpendFragmentTest {
    private lateinit var senario: FragmentScenario<AddSpendFragment>

    @Before
    fun setup() {
        senario = launchFragmentInContainer(themeResId = R.style.Theme_AndroidTDDExample)
        senario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testAddingTest() {
        val amount = 100
        val description = "Testing ui fragment"
        onView(withId(R.id.etAmount)).perform(typeText(amount.toString()))
        onView(withId(R.id.etDescripton)).perform(typeText(description))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnAddAmount)).perform(click())
        onView(withId(R.id.text_view_success_message)).check(matches(withText("Spend added")))
    }
}