package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme
import com.reisfernanda.mynewsapp.presentation.theme.smallSpacing

@Composable
fun LoadingIndicator() {
    Box(modifier = Modifier.fillMaxSize().padding(smallSpacing)) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center).testTag(loadingIndicatorTag)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoadingPreview() {
    MyNewsAppTheme {
        LoadingIndicator()
    }
}