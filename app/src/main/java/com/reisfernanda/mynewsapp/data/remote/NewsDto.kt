package com.reisfernanda.mynewsapp.data.remote

import com.squareup.moshi.Json

data class NewsDto(
    @field:Json(name = "results")
    val news: List<ArticleDto>
)
