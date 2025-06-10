package com.example.firestoreproject

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.firestoreproject.app.YoutubeApp
import com.example.firestoreproject.app.rememberAppState
import com.example.firestoreproject.core.design.compositionlocals.LocalPaddings
import com.example.firestoreproject.core.design.compositionlocals.LocalSizes
import com.example.firestoreproject.core.design.compositionlocals.Paddings
import com.example.firestoreproject.core.design.compositionlocals.Sizes
import com.example.firestoreproject.core.design.theme.AppTheme

@Composable
fun YoutubePreview(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalPaddings provides Paddings(),
        LocalSizes provides Sizes(),
    ) {
        content()
    }
}