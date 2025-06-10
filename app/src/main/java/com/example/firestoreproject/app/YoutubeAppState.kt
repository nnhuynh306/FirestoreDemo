package com.example.firestoreproject.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Stable
class YoutubeAppState(
    val navController: NavHostController,
) {

}

@Composable
fun rememberAppState(): YoutubeAppState {
    val navController = rememberNavController()

    return YoutubeAppState(
        navController = navController
    )
}