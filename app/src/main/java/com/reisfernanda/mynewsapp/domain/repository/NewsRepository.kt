package com.reisfernanda.mynewsapp.domain.repository

import io.reactivex.rxjava3.core.Observable

interface NewsRepository {
    fun getNews(): Observable<List<Article>>
}