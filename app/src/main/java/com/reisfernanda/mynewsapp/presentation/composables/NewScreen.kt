package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.reisfernanda.mynewsapp.R
import com.reisfernanda.mynewsapp.presentation.NewsState
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme

@Composable
fun NewsScreen(state: NewsState) {
    when(state) {
        NewsState.Idle -> {}
        NewsState.Loading -> { LoadingIndicator() }
        is NewsState.Error -> {
            Error(
                errorMessage = state.errorMessage
                    ?: stringResource(R.string.unknown_error)
            )
        }
        is NewsState.News -> News(state = state)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewsScreenPreview() {
    MyNewsAppTheme {
        NewsScreen(
            NewsState.News(
                articles = listOf(
                    com.reisfernanda.mynewsapp.domain.Article(
                        title = "First Article Title!",
                        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                        image = "https://static01.nyt.com/images/2023/11/04/multimedia/2023-10-30-november-polls-topics_tables/2023-10-30-november-polls-topics_tables-superJumbo-v12.jpg",
                        section = "Politics"
                    ),
                    com.reisfernanda.mynewsapp.domain.Article(
                        title = "Second Article Title!",
                        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        image = null,
                        section = "Politics"
                    ),
                    com.reisfernanda.mynewsapp.domain.Article(
                        title = "Third Article Title!",
                        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        image = "https://static01.nyt.com/images/2023/11/06/multimedia/06gaza-medics-01-gqmc/06gaza-medics-01-gqmc-superJumbo.jpg",
                        section = "Politics"
                    )
                )
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoadingNewsPreview() {
    MyNewsAppTheme {
        NewsScreen(NewsState.Loading)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ErrorNewsPreview() {
    MyNewsAppTheme {
        NewsScreen(NewsState.Error(errorMessage = "Unknown error =("))
    }
}