package com.demo.movieapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.demo.movieapp.models.Movies
import com.demo.movieapp.models.getMovies
import com.demo.movieapp.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailsScreen(navController: NavController, movieId: String?) {

    val movieList = getMovies().filter { movie ->
        movie.id == movieId
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                elevation = 5.dp
            ) {
                Row(horizontalArrangement = Arrangement.Start) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBackIosNew,
                        contentDescription = "Back Icon",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
//                    Spacer(modifier = Modifier.width(100.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 1.sp,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        text = "Movie Details"
                    )
                }
            }
        }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                MovieRow(movie = movieList.first())
//                Text(text = movieList.first().title, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Images", style = MaterialTheme.typography.h5)
                HorizontalScrollableImageView(movieList)

            }
        }
    }

}

@Composable
fun HorizontalScrollableImageView(movieList: List<Movies>) {
    LazyRow {
        items(movieList.first().images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Movie Images"
                )
            }
        }
    }
}