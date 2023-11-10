package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.reisfernanda.mynewsapp.presentation.AppScreens
import com.reisfernanda.mynewsapp.presentation.NewsState

@Composable
fun NewsNavHost(
    navController: NavHostController,
    newsState: NewsState
) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.NewsList.name
    ) {
        composable(route = AppScreens.NewsList.name) {
            NewsScreen(newsState) {
                navController.navigate(AppScreens.Section.name)
            }
        }

        composable(route = AppScreens.Section.name) {
            SectionScreen()
        }
    }
}