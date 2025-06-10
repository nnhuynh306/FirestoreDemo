package com.example.firestoreproject.core.design.compositionlocals

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Paddings(
    val horizontalContentPaddingSmall: Dp = 3.dp,
    val horizontalContentPadding: Dp = 5.dp,
    val verticalContentPadding: Dp = 5.dp,
    val textIconPadding: Dp = 4.dp,
    val verticalListItemSpacing: Dp = 4.dp,
    val horizontalListItemSpacing: Dp = 6.dp
)

val LocalPaddings = staticCompositionLocalOf { Paddings() }