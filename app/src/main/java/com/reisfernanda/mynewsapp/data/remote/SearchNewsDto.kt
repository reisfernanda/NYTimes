package com.reisfernanda.mynewsapp.data.remote

import com.squareup.moshi.Json

data class SearchNewsDto(
    val response: SearchDocsDto
)

data class SearchDocsDto(
    @field:Json(name = "docs")
    val articles: List<SearchArticleDto>
)

data class SearchArticleDto(
    val title: String?,
    val abstract: String?,
    @field:Json(name = "multimedia")
    val images: List<SearchImageDto>?,
    @field:Json(name = "section_name")
    val section: String,
    @field:Json(name = "subsection_name")
    val subsection: String?
)

data class SearchImageDto(
    val url: String?,
    @field:Json(name = "subtype")
    val format: String?
)
