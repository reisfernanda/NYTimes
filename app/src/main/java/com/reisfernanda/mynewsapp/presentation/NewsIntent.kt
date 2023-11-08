package com.reisfernanda.mynewsapp.presentation

sealed class NewsIntent {
    object Load: NewsIntent()
}
