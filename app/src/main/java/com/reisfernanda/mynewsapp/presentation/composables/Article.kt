package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.reisfernanda.mynewsapp.R
import com.reisfernanda.mynewsapp.domain.Article
import com.reisfernanda.mynewsapp.presentation.theme.LightGray
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme
import com.reisfernanda.mynewsapp.presentation.theme.smallSpacing
import com.reisfernanda.mynewsapp.presentation.theme.xSmallSpacing
import java.util.Locale

@Composable
fun Article(
    article: Article,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(smallSpacing),
        colors = CardDefaults.cardColors(containerColor = LightGray)
    ) {
        Box {
            AsyncImage(
                model = article.image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
                placeholder = painterResource(id = R.drawable.placeholder_image)
            )
            Text(
                text = article.section.uppercase(Locale.getDefault()),
                modifier = Modifier
                    .padding(smallSpacing)
                    .background(Color.Red, RoundedCornerShape(4.dp))
                    .align(Alignment.BottomEnd)
                    .padding(xSmallSpacing),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
        }
        Text(
            text = article.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(smallSpacing)
        )
        Text(
            text = article.abstract,
            textAlign = TextAlign.Justify,
            fontSize = 14.sp,
            modifier = Modifier.padding(smallSpacing)
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
                image = "https://static01.nyt.com/images/2023/11/06/multimedia/06gaza-medics-01-gqmc/06gaza-medics-01-gqmc-superJumbo.jpg",
                section = "Politics"
            )
        )
    }
}