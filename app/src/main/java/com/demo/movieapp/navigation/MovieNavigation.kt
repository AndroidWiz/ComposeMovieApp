package com.demo.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.demo.movieapp.screens.home.HomeScreen
import com.demo.movieapp.screens.details.MovieDetailsScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            // passing where to lead to
            HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) {backStackEntry ->

            // passing where to lead to
            MovieDetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}