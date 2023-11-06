package com.reisfernanda.mynewsapp.di

import com.reisfernanda.mynewsapp.data.repository.NewsRepositoryImpl
import com.reisfernanda.mynewsapp.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class NewsModule {

    @Binds
    abstract fun provideNewsRepository(repositoryImpl: NewsRepositoryImpl): NewsRepository
}