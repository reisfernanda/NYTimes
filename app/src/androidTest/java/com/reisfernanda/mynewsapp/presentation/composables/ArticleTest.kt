package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.reisfernanda.mynewsapp.util.getFakeNewsState
import org.junit.Rule
import org.junit.Test

class ArticleTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun givenStateHasArticles_whenCompose_shouldShowNews() {
        val article = getFakeNewsState().articles!!.first()

        rule.setContent {
            Article(article)
        }

        rule.onNodeWithText(article.title).assertExists()
        rule.onNodeWithText(article.abstract).assertExists()
        rule.onNodeWithText(article.section.uppercase()).assertExists()
    }
}