package com.demo.movieapp.screens.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.movieapp.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Magenta,
                elevation = 5.dp
            ) {
                Text(text = "Movies")
            }
        }) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Avatar",
        "Titanic",
        "Avatar",
        "Titanic",
        "Avatar",
        "Titanic"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        val context = LocalContext.current
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    Toast.makeText(context, movie, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}