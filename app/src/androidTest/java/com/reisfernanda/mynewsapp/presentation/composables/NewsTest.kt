package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.reisfernanda.mynewsapp.presentation.NewsState
import com.reisfernanda.mynewsapp.util.getFakeNewsState
import org.junit.Rule
import org.junit.Test

class NewsTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun givenStateHasArticles_whenCompose_shouldShowNews() {
        val state = getFakeNewsState()

        rule.setContent {
            News(state = state)
        }

        for (article in state.articles!!) {
            rule.onNodeWithText(article.title).assertExists()
            rule.onNodeWithText(article.abstract).assertExists()
            rule.onNodeWithText(article.section.uppercase()).assertExists()
        }
        rule.onNodeWithTag(loadingIndicatorTag).assertDoesNotExist()
        rule.onNodeWithTag(errorTag).assertDoesNotExist()
    }

    @Test
    fun givenStateHasError_whenCompose_shouldShowError() {
        val errorMessage = "Unknown error"

        rule.setContent {
            News(state = NewsState(errorMessage = errorMessage))
        }

        rule.onNodeWithText(errorMessage).assertExists()
        rule.onNodeWithTag(loadingIndicatorTag).assertDoesNotExist()
    }

    @Test
    fun givenStateHasLoadingTrue_whenCompose_shouldShowLoadingIndicator() {
        rule.setContent {
            News(state = NewsState(isLoading = true))
        }

        rule.onNodeWithTag(loadingIndicatorTag).assertExists()
        rule.onNodeWithTag(errorTag).assertDoesNotExist()
    }
}