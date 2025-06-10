package com.example.firestoreproject.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

data class TopLevelDestination<RouteT>(
    val icon: ImageVector,
    val selectedIcon: ImageVector,
    val labelId: Int,
    val route: RouteT,
) {

}