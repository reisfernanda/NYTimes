package com.reisfernanda.mynewsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.reisfernanda.mynewsapp.NewsApp
import com.reisfernanda.mynewsapp.di.AppComponent
import com.reisfernanda.mynewsapp.presentation.composables.NewsScreen
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var appComponent: AppComponent

    private val viewModel: NewsViewModel by viewModels {
        appComponent.viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = (application as NewsApp).getComponent()
        appComponent.inject(this)

        viewModel.onEvent(NewsIntent.Load)

        super.onCreate(savedInstanceState)
        setContent {
            MyNewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsScreen(viewModel.state)
                }
            }
        }
    }
}