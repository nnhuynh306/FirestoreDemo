package com.example.firestoreproject.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.firestoreproject.R
import com.example.firestoreproject.YoutubePreview
import com.example.firestoreproject.app.navigation.TopLevelDestination
import com.example.firestoreproject.app.navigation.YoutubeNavHost
import com.example.firestoreproject.core.design.widgets.YoutubeBottomNavItem
import com.example.firestoreproject.core.design.widgets.YoutubeBottomNavigationBar
import com.example.firestoreproject.features.home.navigation.HomeRoute
import com.example.firestoreproject.features.profile.navigation.ProfileRoute

@Composable
fun YoutubeApp(appState: YoutubeAppState) {
    val selectedIndex = rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            YoutubeBottomNavigationBar {
                for (index in topLevelDestination.indices) {
                    val destination = topLevelDestination[index]
                    YoutubeBottomNavItem(
                        onClick = {
                            selectedIndex.intValue = index
                            appState.navigateToTopLevelDestination(destination)
                        },
                        icon = destination.icon,
                        selectedIcon = destination.selectedIcon,
                        isSelected = selectedIndex.intValue == index,
                        label = stringResource(destination.labelId)
                    )
                }
            }
        }
    ) { innerPaddings ->
        YoutubeNavHost(
            modifier = Modifier
                .padding(bottom = innerPaddings.calculateBottomPadding()),
            appState = appState,
        )
    }
}

val topLevelDestination = listOf(
    TopLevelDestination(
        icon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
        labelId = R.string.top_level_destination_home_label,
        route = HomeRoute
    ),
    TopLevelDestination(
        icon = Icons.Outlined.Person,
        selectedIcon = Icons.Filled.Person,
        labelId = R.string.top_level_destination_profile_label,
        route = ProfileRoute
    )
)

fun YoutubeAppState.navigateToTopLevelDestination(topLevelDestination: TopLevelDestination<out Any>) {
    navController.navigate(topLevelDestination.route)
}

@Preview
@Composable
fun YoutubeAppPreview() {
    YoutubePreview {
        YoutubeApp(appState = rememberAppState())
    }
}