package com.reisfernanda.mynewsapp.presentation

import com.reisfernanda.mynewsapp.domain.repository.Article

data class NewsState(
    val isLoading: Boolean = false,
    val errorMessage: String ?= null,
    val articles: List<Article> ?= null
)
