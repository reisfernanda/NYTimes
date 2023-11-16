package com.reisfernanda.mynewsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.reisfernanda.mynewsapp.NewsApp
import com.reisfernanda.mynewsapp.presentation.composables.NewsNavHost
import com.reisfernanda.mynewsapp.presentation.theme.MyNewsAppTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: NewsViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as NewsApp).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        viewModel.onEvent(NewsIntent.Load)

        setContent {
            MyNewsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController: NavHostController = rememberNavController()
                    NewsNavHost(
                        navController = navController,
                        newsState = viewModel.state,
                        onLoadSectionNews = {
                            viewModel.onEvent(NewsIntent.LoadSection(it))
                        }
                    )
                }
            }
        }
    }
}