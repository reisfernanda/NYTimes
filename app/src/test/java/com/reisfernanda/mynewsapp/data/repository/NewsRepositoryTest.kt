package com.reisfernanda.mynewsapp.data.repository

import com.reisfernanda.mynewsapp.data.remote.NewsApi
import com.reisfernanda.mynewsapp.util.getFakeArticles
import com.reisfernanda.mynewsapp.util.getFakeNewsDto
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Observable
import org.junit.Test

class NewsRepositoryTest {

    private val newsApiMock = mockk<NewsApi>()
    private val newsRepository = NewsRepositoryImpl(newsApiMock)

    @Test
    fun givenApiReturnsSuccess_whenGetNews_shouldReturnNews() {
        // GIVEN
        every { newsApiMock.getNews() } returns Observable.just(getFakeNewsDto())

        // WHEN
        val result = newsRepository.getNews()

        // THEN
        result.test().assertValue(getFakeArticles())
    }

    @Test
    fun givenApiReturnsError_whenGetNews_shouldReturnNews() {
        // GIVEN
        val exception = Exception("Unknown error")
        every { newsApiMock.getNews() } returns Observable.error(exception)

        // WHEN
        val result = newsRepository.getNews()

        // THEN
        result.test().assertError(exception)
    }
}