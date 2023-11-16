package com.reisfernanda.mynewsapp.presentation

sealed class NewsIntent {
    object Load: NewsIntent()
    data class LoadSection(val section: String): NewsIntent()
}
