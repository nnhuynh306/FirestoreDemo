package com.example.firestoreproject.features.home

import android.nfc.Tag
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firestoreproject.core.design.compositionlocals.LocalSizes
import com.example.firestoreproject.core.design.widgets.ScrollViewWithTopAppBar
import com.example.firestoreproject.core.design.widgets.YoutubeTopAppBar

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    HomeScreenContent(
        listTag = listOf("Music", "Gaming")
    )
}

@Composable
fun HomeScreenContent(
    listTag: List<String>,
) {
    val topAppBarHeight = LocalSizes.current.topAppBarHeight
    val expandedTopAppBarHeight = topAppBarHeight
    val totalTopAppBarHeight = topAppBarHeight + expandedTopAppBarHeight

    ScrollViewWithTopAppBar(
        appBar = {
            YoutubeTopAppBar(
                nonExtendedWidgetHeight = topAppBarHeight,
                extendedWidgetHeight = topAppBarHeight,
            )
        },
        appBarHeight = totalTopAppBarHeight,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(100) {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
                    .background(color = Color.Red),
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenContent(
        listOf("Music", "Gaming")
    )
}