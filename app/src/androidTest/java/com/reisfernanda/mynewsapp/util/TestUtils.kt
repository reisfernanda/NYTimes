package com.reisfernanda.mynewsapp.util

import com.reisfernanda.mynewsapp.domain.Article
import com.reisfernanda.mynewsapp.presentation.NewsState

fun getFakeNewsState(): NewsState {
    return NewsState(
        articles = listOf(
            Article(
                title = "First Article Title!",
                abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                image = "https://static01.nyt.com/images/2023/11/06/multimedia/06pol-what-to-watch-qvwm/06pol-what-to-watch-qvwm-threeByTwoSmallAt2X.jpg",
                section = "Politics"
            ),
            Article(
                title = "Second Article Title!",
                abstract = "Lorem ipsum dolor sit amet.",
                image = null,
                section = "Technology"
            )
        )
    )
}