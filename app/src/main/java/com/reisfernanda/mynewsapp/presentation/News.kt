package com.reisfernanda.mynewsapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun News(
    state: NewsState,
    modifier: Modifier = Modifier
) {
    state.articles?.let { articles ->
        LazyColumn(
            modifier = modifier.padding(16.dp),
            content = {
                items(articles) {
                    Article(article = it)
                }
            }
        )
    }
}