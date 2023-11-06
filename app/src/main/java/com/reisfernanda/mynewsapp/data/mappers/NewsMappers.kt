package com.reisfernanda.mynewsapp.data.mappers

import com.reisfernanda.mynewsapp.data.remote.ArticleDto
import com.reisfernanda.mynewsapp.data.remote.NewsDto
import com.reisfernanda.mynewsapp.domain.repository.Article

fun NewsDto.toDomain(): List<Article> {
    return this.news.mapNotNull {
        it.toDomain()
    }
}

private fun ArticleDto.toDomain(): Article? {
    return Article(
        title = this.title ?: return null,
        abstract = this.abstract ?: return null,
        image = this.images?.firstOrNull()?.url
    )
}