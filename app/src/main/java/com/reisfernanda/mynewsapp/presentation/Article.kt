package com.reisfernanda.mynewsapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.reisfernanda.mynewsapp.domain.repository.Article

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