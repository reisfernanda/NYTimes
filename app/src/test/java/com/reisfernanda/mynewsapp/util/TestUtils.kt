package com.reisfernanda.mynewsapp.util

import com.reisfernanda.mynewsapp.data.remote.ArticleDto
import com.reisfernanda.mynewsapp.data.remote.ImageDto
import com.reisfernanda.mynewsapp.data.remote.NewsDto
import com.reisfernanda.mynewsapp.domain.Article

fun getFakeNewsDto(): NewsDto {
    return NewsDto(
        news = listOf(
            ArticleDto(
                title = "First Article Title!",
                abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                images = listOf(
                    ImageDto(
                        url = "https://static01.nyt.com/images/2023/11/04/12.jpg",
                        format = null
                    )
                ),
                section = "Politics",
                subsection = null
            ),
            ArticleDto(
                title = "Second Article Title!",
                abstract = "Lorem ipsum dolor sit amet.",
                images = listOf(
                    ImageDto(
                        url = "https://static01.nyt.com/images/2023/11/04/multimedia/13.jpg",
                        format = "threeByTwoSmallAt2X"
                    )
                ),
                section = "News",
                subsection = "Technology"
            )
        )
    )
}

fun getFakeArticles(): List<Article> {
    return listOf(
        Article(
            title = "First Article Title!",
            abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            image = null,
            section = "Politics"
        ),
        Article(
            title = "Second Article Title!",
            abstract = "Lorem ipsum dolor sit amet.",
            image = "https://static01.nyt.com/images/2023/11/04/multimedia/13.jpg",
            section = "Technology"
        )
    )
}