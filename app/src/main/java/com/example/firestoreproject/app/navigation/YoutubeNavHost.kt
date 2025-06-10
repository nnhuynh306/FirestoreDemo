package com.example.firestoreproject.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.firestoreproject.app.YoutubeAppState
import com.example.firestoreproject.features.home.navigation.HomeRoute
import com.example.firestoreproject.features.home.navigation.homeScreen
import com.example.firestoreproject.features.profile.navigation.profileScreen

@Composable
fun YoutubeNavHost(
    modifier: Modifier = Modifier,
    appState: YoutubeAppState
) {
    val navController = appState.navController

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HomeRoute,
    ) {
        homeScreen()
        profileScreen()
    }
}