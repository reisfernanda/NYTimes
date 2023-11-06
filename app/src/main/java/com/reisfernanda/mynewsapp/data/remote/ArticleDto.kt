package com.reisfernanda.mynewsapp.data.remote

import com.squareup.moshi.Json

data class ArticleDto(
    val title: String?,
    val abstract: String?,
    @field:Json(name = "multimedia")
    val images: List<ImageDto>?
)
