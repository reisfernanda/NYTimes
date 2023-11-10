package com.reisfernanda.mynewsapp.presentation.composables

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface NewsDestination {
    val route: String
}

object NewsList: NewsDestination {
    override val route = "news_list"
}

object SectionDetails: NewsDestination {
    override val route = "section_details"
    const val sectionArg = "section"
    val routeWithArgs = "$route/{$sectionArg}"
    val arguments = listOf(
        navArgument(sectionArg) { type = NavType.StringType }
    )
}