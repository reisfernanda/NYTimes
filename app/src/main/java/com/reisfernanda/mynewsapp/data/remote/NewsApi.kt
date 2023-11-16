package com.reisfernanda.mynewsapp.data.remote

import com.reisfernanda.mynewsapp.BuildConfig
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {
    @GET("svc/topstories/v2/home.json?api-key=${BuildConfig.API_KEY}")
    fun getNews(): Observable<NewsDto>

    @GET("svc/topstories/v2/{section}.json?api-key=${BuildConfig.API_KEY}")
    fun getSectionNews(
        @Path("section") section: String
    ): Observable<NewsDto>

    @GET("svc/search/v2/articlesearch.json?api-key=${BuildConfig.API_KEY}")
    fun searchNews(
        @Query("q") searchQuery: String
    ): Observable<SearchNewsDto>
}