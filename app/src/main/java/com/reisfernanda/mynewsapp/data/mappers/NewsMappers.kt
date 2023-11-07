package com.reisfernanda.mynewsapp.data.mappers

import com.reisfernanda.mynewsapp.data.remote.ArticleDto
import com.reisfernanda.mynewsapp.data.remote.NewsDto
import com.reisfernanda.mynewsapp.domain.Article

fun NewsDto.toDomain(): List<Article> {
    return this.news.mapNotNull {
        it.toDomain()
    }
}

private fun ArticleDto.toDomain(): Article? {
    return Article(
        title = this.title ?: return null,
        abstract = this.abstract ?: return null,
        image = this.images?.firstOrNull {
            it.format.equals("threeByTwoSmallAt2X")
        }?.url,
        section = subsection?.takeIf { it.isNotEmpty() } ?: section
    )
}