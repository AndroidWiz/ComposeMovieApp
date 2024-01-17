package com.demo.movieapp.screens.home

import android.annotation.SuppressLint
import androidx.annotation.AttrRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.demo.movieapp.models.Movies
import com.demo.movieapp.models.getMovies
import com.demo.movieapp.navigation.MovieScreens
import com.demo.movieapp.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                elevation = 5.dp
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 1.sp,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    text = "Movies"
                )
            }
        }) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movies> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        val context = LocalContext.current
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
//                    navController.navigate(route = "details_screen/${movie}")
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/${movie}")
                }
            }
        }
    }
}