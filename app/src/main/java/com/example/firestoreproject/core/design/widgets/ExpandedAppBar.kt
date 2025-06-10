package com.example.firestoreproject.core.design.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.ConnectedTv
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.firestoreproject.R
import com.example.firestoreproject.core.design.compositionlocals.LocalPaddings
import com.example.firestoreproject.core.design.compositionlocals.LocalSizes
import java.time.format.TextStyle

/**
 * [height], [horizontalPadding] does not effect [extendedWidget]
 */
@Composable
fun ExtendedAppBar(
    title: @Composable () -> Unit,
    actions: @Composable (RowScope.() -> Unit)? = null,
    horizontalPadding: Dp = LocalPaddings.current.horizontalContentPadding,
    height: Dp = LocalSizes.current.topAppBarHeight,
    extendedWidget: @Composable (() -> Unit)? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .height(height)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = horizontalPadding)
                ) {
                    title()
                }

                Row(

                ) {
                    actions?.invoke(this)
                }
            }

            extendedWidget?.invoke()
        }
    }
}

@Composable
fun YoutubeTopAppBar(
    nonExtendedWidgetHeight: Dp,
    extendedWidgetHeight: Dp,
    extendedWidget: @Composable (() -> Unit)? = null,
) {
    ExtendedAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(LocalSizes.current.iconBig),
                    painter = painterResource(R.drawable.ic_app),
                    contentDescription = "",
                    tint = Color.Unspecified,
                )
                Spacer(
                    Modifier.width(
                        width = LocalPaddings.current.textIconPadding
                    )
                )
                Text(
                    stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        actions = {
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ConnectedTv,
                    contentDescription = ""
                )
            }
            IconButton(
                onClick = {

                }
            ) {
                BadgedBox(
                    badge = {
                        Badge(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ) {
                            Text("5")
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = ""
                    )
                }
            }
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = ""
                )
            }
        },
        height = nonExtendedWidgetHeight,
        extendedWidget = extendedWidget
    )
}

@Preview
@Composable
fun YoutubeTopAppBarPreview(

) {
    YoutubeTopAppBar(
        48.dp, 48.dp
    )
}