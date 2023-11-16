package com.reisfernanda.mynewsapp.data.repository

import com.reisfernanda.mynewsapp.data.mappers.toDomain
import com.reisfernanda.mynewsapp.data.remote.NewsApi
import com.reisfernanda.mynewsapp.domain.Article
import com.reisfernanda.mynewsapp.domain.repository.NewsRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
): NewsRepository {
    override fun getNews(): Observable<List<Article>> {
        return newsApi.getNews().map {
            it.toDomain()
        }
    }

    override fun getSectionNews(section: String): Observable<List<Article>> {
        return newsApi.getSectionNews(section).map {
            it.toDomain()
        }
    }

    override fun getSearchNews(searchQuery: String): Observable<List<Article>> {
        return newsApi.searchNews(searchQuery).map {
            it.toDomain()
        }
    }
}