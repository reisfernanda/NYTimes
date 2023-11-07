package com.reisfernanda.mynewsapp.presentation

import com.reisfernanda.mynewsapp.domain.repository.NewsRepository
import com.reisfernanda.mynewsapp.util.RxImmediateSchedulerRule
import com.reisfernanda.mynewsapp.util.getFakeArticles
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Observable
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNull
import org.junit.Rule
import org.junit.Test

class NewsViewModelTest {
    private val newsRepositoryMock = mockk<NewsRepository>()
    private val newsViewModel = NewsViewModel(newsRepositoryMock)

    @get:Rule
    val schedulers = RxImmediateSchedulerRule()

    @Test
    fun givenRepositoryReturnsSuccess_whenLoadNews_shouldUpdateStateWithNews() {
        // GIVEN
        val articles = getFakeArticles()
        every { newsRepositoryMock.getNews() } returns Observable.just(articles)

        // WHEN
        newsViewModel.loadNews()

        // THEN
        with(newsViewModel.state) {
            assertEquals(articles, this.articles)
            assertNull(this.errorMessage)
            assertFalse(this.isLoading)
        }
    }

    @Test
    fun givenRepositoryReturnsError_whenLoadNews_shouldUpdateStateWithError() {
        // GIVEN
        val errorMessage = "Unknown error"
        every { newsRepositoryMock.getNews() } returns Observable.error(Exception(errorMessage))

        // WHEN
        newsViewModel.loadNews()

        // THEN
        with(newsViewModel.state) {
            assertEquals(errorMessage, this.errorMessage)
            assertNull(this.articles)
            assertFalse(this.isLoading)
        }
    }
}