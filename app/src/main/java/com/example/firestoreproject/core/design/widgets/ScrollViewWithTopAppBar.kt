package com.example.firestoreproject.core.design.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun ScrollViewWithTopAppBar(
    modifier: Modifier = Modifier,
    appBar: @Composable (() -> Unit)? = null,
    appBarHeight: Dp? = null,
    scrollableContent: LazyListScope.() -> Unit
) {
    assert(if (appBar != null) appBarHeight != null else true)

    val statusBarSizePx = with(LocalDensity.current) {
        WindowInsets.statusBars.getTop(this)
    }
    val statusBarSizeDp = with(LocalDensity.current) {
        statusBarSizePx.toDp()
    }

    val appBarHeightPx = with(LocalDensity.current) {
        appBarHeight?.toPx() ?: 0
    }

    val offsetAppBar = remember(statusBarSizePx) {
        mutableIntStateOf(0)
    }

    println(statusBarSizePx)

    val nestedScrollConnection = remember(statusBarSizePx) {
        object: NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                offsetAppBar.intValue = (available.y + offsetAppBar.intValue)
                    .coerceIn(-appBarHeightPx.toFloat() - statusBarSizePx.toFloat(), 0f).toInt()

                return Offset.Zero
            }
        }
    }

    Box(
        modifier = modifier
            .nestedScroll(nestedScrollConnection)
    ) {
        LazyColumn(
            modifier = Modifier,
            contentPadding = PaddingValues(top = (appBarHeight ?: 0.dp) + statusBarSizeDp)
        ) {
            scrollableContent()
        }

        if (appBar != null) {
            Column(
                modifier = Modifier
                    .offset {
                        IntOffset(0, offsetAppBar.intValue)
                    }
            ) {
                Box(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                        .fillMaxWidth()
                        .height(statusBarSizeDp)
                )
                appBar()
            }
        }
    }
}