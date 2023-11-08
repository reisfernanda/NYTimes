package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme

@Composable
fun Error(errorMessage: String) {
    Box(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        Text(
            text = errorMessage,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .testTag(errorTag)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ErrorPreview() {
    MyNewsAppTheme {
        Error("This is an error!")
    }
}