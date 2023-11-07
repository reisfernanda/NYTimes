package com.reisfernanda.mynewsapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reisfernanda.mynewsapp.domain.Article
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme

@Composable
fun News(
    state: NewsState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize().padding(16.dp)) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        state.articles?.let { articles ->
            LazyColumn(
                content = {
                    items(articles) {
                        Article(article = it)
                    }
                }
            )
        }

        state.errorMessage?.let {
            Text(
                text = it,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsPreview() {
    MyNewsAppTheme {
        News(
            NewsState(
                articles = listOf(
                    Article(
                        title = "First Article Title!",
                        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                        image = "https://static01.nyt.com/images/2023/11/04/multimedia/2023-10-30-november-polls-topics_tables/2023-10-30-november-polls-topics_tables-superJumbo-v12.jpg"
                    ),
                    Article(
                        title = "Second Article Title!",
                        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        image = null
                    ),
                    Article(
                        title = "Third Article Title!",
                        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        image = "https://static01.nyt.com/images/2023/11/06/multimedia/06gaza-medics-01-gqmc/06gaza-medics-01-gqmc-superJumbo.jpg"
                    )
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingNewsPreview() {
    MyNewsAppTheme {
        News(NewsState(isLoading = true))
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorNewsPreview() {
    MyNewsAppTheme {
        News(NewsState(errorMessage = "Unknown error =("))
    }
}