package com.kirabium.relayance

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId

@RunWith(AndroidJUnit4::class)
class MainActivityListTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    // Vérifie qu'on a bien 5 éléments dans la liste au démarrage
    @Test
    fun mainActivity_shouldDisplayFiveCustomersOnStart() {
        onView(withId(R.id.customerRecyclerView))
            .check(RecyclerViewItemCountAssertion.withItemCount(5))
    }
}