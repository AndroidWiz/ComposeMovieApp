package com.demo.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.demo.movieapp.screens.home.HomeScreen

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
    }
}