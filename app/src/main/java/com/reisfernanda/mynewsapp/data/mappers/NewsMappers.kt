package com.reisfernanda.mynewsapp.data.mappers

import com.reisfernanda.mynewsapp.data.remote.ArticleDto
import com.reisfernanda.mynewsapp.data.remote.NewsDto
import com.reisfernanda.mynewsapp.data.remote.SearchArticleDto
import com.reisfernanda.mynewsapp.data.remote.SearchNewsDto
import com.reisfernanda.mynewsapp.domain.Article

fun NewsDto.toDomain(): List<Article> {
    return this.news.mapNotNull {
        it.toDomain()
    }
}

fun SearchNewsDto.toDomain(): List<Article> {
    return this.response.articles.mapNotNull {
        it.toDomain()
    }
}

private fun ArticleDto.toDomain(): Article? {
    return Article(
        title = this.title,
        abstract = this.abstract ?: return null,
        image = this.images?.firstOrNull {
            it.format.equals("threeByTwoSmallAt2X")
        }?.url,
        section = subsection?.takeIf { it.isNotEmpty() } ?: section
    )
}

private fun SearchArticleDto.toDomain(): Article? {
    return Article(
        title = this.title,
        abstract = this.abstract ?: return null,
        image = this.images?.firstOrNull {
            it.format.equals("threeByTwoSmallAt2X")
        }?.url,
        section = subsection?.takeIf { it.isNotEmpty() } ?: section
    )
}