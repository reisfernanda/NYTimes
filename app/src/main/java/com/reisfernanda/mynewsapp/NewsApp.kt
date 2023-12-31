package com.reisfernanda.mynewsapp

import android.app.Application
import com.reisfernanda.mynewsapp.di.AppComponent
import com.reisfernanda.mynewsapp.di.DaggerAppComponent

class NewsApp: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}