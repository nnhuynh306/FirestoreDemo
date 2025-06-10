package com.example.firestoreproject.core.design.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.firestoreproject.core.design.compositionlocals.LocalPaddings
import com.example.firestoreproject.core.design.compositionlocals.LocalSizes

@Composable
fun YoutubeBottomNavigationBar(
    height: Dp = LocalSizes.current.bottomNavBarHeight,
    content: @Composable RowScope.() -> Unit
) {
    val navBarHeight = with(LocalDensity.current) {
        WindowInsets.navigationBars.getBottom(this).toDp()
    }

    Row(
        modifier = Modifier
            .height(height + navBarHeight)
            .padding(bottom = navBarHeight)
            .fillMaxWidth()
            .topBorder(
                color = MaterialTheme.colorScheme.onSurface
            ),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
       content()
    }
}

@Composable
fun YoutubeBottomNavItem(
    onClick: () -> Unit,
    icon: ImageVector,
    selectedIcon: ImageVector,
    isSelected: Boolean,
    label: String,
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple()
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                modifier = Modifier,
                imageVector = if (isSelected) selectedIcon else icon,
                contentDescription = ""
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview
@Composable
fun YoutubeNavItemPreview() {
    YoutubeBottomNavItem(
        onClick = {

        },
        icon = Icons.Filled.Person,
        selectedIcon = Icons.Outlined.Person,
        isSelected = true,
        label = "Home"
    )
}