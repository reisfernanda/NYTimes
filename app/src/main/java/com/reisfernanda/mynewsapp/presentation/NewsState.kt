package com.reisfernanda.mynewsapp.presentation

import com.reisfernanda.mynewsapp.domain.Article

sealed class NewsState {
    object Idle: NewsState()
    object Loading: NewsState()
    data class Error(val errorMessage: String?): NewsState()
    data class News(val articles: List<Article>, val section: String? = null): NewsState()
}
