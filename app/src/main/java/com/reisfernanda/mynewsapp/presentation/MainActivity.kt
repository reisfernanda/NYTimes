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
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var appComponent: AppComponent

    private val viewModel: NewsViewModel by viewModels {
        appComponent.viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = (application as NewsApp).getComponent()

        appComponent.inject(this)

        viewModel.loadNews()

        super.onCreate(savedInstanceState)
        setContent {
            MyNewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    News(state = viewModel.state)
                }
            }
        }
    }
}