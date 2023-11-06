package com.reisfernanda.mynewsapp.data.remote

import com.reisfernanda.mynewsapp.BuildConfig
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface NewsApi {
    @GET("svc/topstories/v2/home.json?api-key=${BuildConfig.API_KEY}")
    fun getNews(): Observable<NewsDto>
}