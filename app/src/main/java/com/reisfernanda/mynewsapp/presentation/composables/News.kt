package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.reisfernanda.mynewsapp.domain.Article
import com.reisfernanda.mynewsapp.presentation.NewsState
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme
import com.reisfernanda.mynewsapp.presentation.theme.smallSpacing

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun News(
    state: NewsState.News,
    modifier: Modifier = Modifier,
    onSectionClicked: (String) -> Unit = {}
) {
    Column(modifier = modifier) {
        LazyColumn(
            content = {
                state.section?.let {
                    stickyHeader {
                        Surface(Modifier.fillParentMaxWidth()) {
                            Text(
                                text = "Latest ${state.section} news",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(smallSpacing)
                            )
                        }
                    }
                }
                items(state.articles) {
                    Article(article = it, onSectionClicked = onSectionClicked)
                }
            }
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewsPreview() {
    MyNewsAppTheme {
        News(
            NewsState.News(
                articles = listOf(
                    Article(
                        title = "First Article Title!",
                        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                        image = "https://static01.nyt.com/images/2023/11/04/multimedia/2023-10-30-november-polls-topics_tables/2023-10-30-november-polls-topics_tables-superJumbo-v12.jpg",
                        section = "Politics"
                    ),
                    Article(
                        title = "Second Article Title!",
                        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                        image = null,
                        section = "Politics"
                    ),
                    Article(
                        title = "Third Article Title!",
                        abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        image = "https://static01.nyt.com/images/2023/11/06/multimedia/06gaza-medics-01-gqmc/06gaza-medics-01-gqmc-superJumbo.jpg",
                        section = "Politics"
                    )
                )
            ),
            onSectionClicked = {}
        )
    }
}