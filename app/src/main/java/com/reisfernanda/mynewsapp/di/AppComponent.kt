package com.reisfernanda.mynewsapp.di

import com.reisfernanda.mynewsapp.presentation.MainActivity
import com.reisfernanda.mynewsapp.presentation.ViewModelFactory
import dagger.Component

@Component(modules = [NewsModule::class, AppModule::class])
interface AppComponent {

    fun viewModelsFactory(): ViewModelFactory

    fun inject(activity: MainActivity)
}