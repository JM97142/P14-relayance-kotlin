package com.kirabium.relayance

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.rule.ActivityTestRule
import com.kirabium.relayance.ui.activity.DetailActivity
import com.kirabium.relayance.ui.activity.MainActivity
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kirabium.relayance.R
import com.kirabium.relayance.ui.adapter.CustomerAdapter

@RunWith(AndroidJUnit4::class)
class MainActivityIntentTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    // Simule clic sur le premier élément de la liste
    // et vérifier que l'Intent a le bon ID
    @Test
    fun clickingFirstItem_shouldLaunchDetailActivityWithCorrectId() {
        onView(withId(R.id.customerRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<CustomerAdapter.CustomerViewHolder>(
                    0,
                    click()
                )
            )

        Intents.intended(
            allOf(
                hasComponent(DetailActivity::class.java.name),
                hasExtra(DetailActivity.EXTRA_CUSTOMER_ID, 1)
            )
        )
    }
}