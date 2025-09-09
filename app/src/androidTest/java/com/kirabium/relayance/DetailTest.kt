package com.kirabium.relayance

import android.content.Intent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ActivityScenario
import com.kirabium.relayance.ui.activity.DetailActivity
import org.junit.Rule
import org.junit.Test

class DetailTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<DetailActivity>()

    @Test
    fun detailActivity_shouldDisplayCustomerInfo_whenLaunchedWithIntent() {
        val intent = Intent(composeTestRule.activity, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_CUSTOMER_ID, 1)
        }

        ActivityScenario.launch<DetailActivity>(intent)

        // Vérifie que les informations de l'id de 'Alice Wonderland' (1) sont affichés
        composeTestRule.onNodeWithText("Alice Wonderland").assertExists()
        composeTestRule.onNodeWithText("alice@example.com").assertExists()
    }
}