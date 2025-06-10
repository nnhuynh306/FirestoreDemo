package com.example.firestoreproject.core.design.compositionlocals

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Sizes(
    val topAppBarHeight: Dp = 42.dp,
    val bottomNavBarHeight: Dp = 52.dp,
    val iconBig: Dp = 36.dp,
    val tagHeight: Dp = 32.dp,
    val buttonCornerRadius: Dp = 5.dp,
)

val LocalSizes = staticCompositionLocalOf { Sizes() }

