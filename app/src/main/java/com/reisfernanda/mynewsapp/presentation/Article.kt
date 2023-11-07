package com.reisfernanda.mynewsapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.reisfernanda.mynewsapp.domain.Article
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme

@Composable
fun Article(
    article: Article,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp)
    ) {
        AsyncImage(model = article.image, contentDescription = null)
        Text(
            text = article.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = article.abstract,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    MyNewsAppTheme {
        Article(
            article = Article(
                title = "Third Article Title!",
                abstract = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                image = "https://static01.nyt.com/images/2023/11/06/multimedia/06gaza-medics-01-gqmc/06gaza-medics-01-gqmc-superJumbo.jpg"
            )
        )
    }
}