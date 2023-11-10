package com.reisfernanda.mynewsapp.presentation.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.reisfernanda.mynewsapp.presentation.NewsState

@Composable
fun NewsNavHost(
    navController: NavHostController,
    newsState: NewsState
) {
    NavHost(
        navController = navController,
        startDestination = NewsList.route
    ) {
        composable(route = NewsList.route) {
            NewsScreen(
                state = newsState,
                onSectionClicked = { section ->
                    navController.navigate(
                        "${SectionDetails.route}/$section"
                    )
                }
            )
        }

        composable(
            route = SectionDetails.routeWithArgs,
            arguments = SectionDetails.arguments
        ) { navBackStackEntry ->
            val section = navBackStackEntry.arguments?.getString(SectionDetails.sectionArg).orEmpty()
            SectionScreen(section)
        }
    }
}