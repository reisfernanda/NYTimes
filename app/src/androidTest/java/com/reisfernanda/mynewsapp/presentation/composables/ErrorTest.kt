package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ErrorTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun givenStateHasArticles_whenCompose_shouldShowNews() {
        val errorMessage = "error message"

        rule.setContent {
            Error(errorMessage)
        }

        rule.onNodeWithText(errorMessage).assertExists()
    }
}