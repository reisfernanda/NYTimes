package com.reisfernanda.mynewsapp.domain.repository

import com.reisfernanda.mynewsapp.domain.Article
import io.reactivex.rxjava3.core.Observable

interface NewsRepository {
    fun getNews(): Observable<List<Article>>

    fun getSectionNews(section: String): Observable<List<Article>>

    fun getSearchNews(searchQuery: String): Observable<List<Article>>
}