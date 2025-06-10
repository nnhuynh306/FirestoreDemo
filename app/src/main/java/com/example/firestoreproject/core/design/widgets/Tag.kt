package com.example.firestoreproject.core.design.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.firestoreproject.core.design.compositionlocals.LocalPaddings
import com.example.firestoreproject.core.design.compositionlocals.LocalSizes
import kotlinx.coroutines.flow.combineTransform

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isSelected: Boolean = false,
    height: Dp = LocalSizes.current.tagHeight,
    text: String? = null,
    icon: ImageVector? = null,
    padding: PaddingValues = PaddingValues(
        horizontal = LocalPaddings.current.horizontalContentPadding,
        vertical = LocalPaddings.current.verticalContentPadding
    ),
    containerShape: Shape = RoundedCornerShape(LocalSizes.current.buttonCornerRadius)
) {
    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.tertiary
    } else {
        MaterialTheme.colorScheme.background
    }

    val contentColor = if (isSelected) {
        MaterialTheme.colorScheme.onTertiary
    } else {
        MaterialTheme.colorScheme.onBackground
    }

    Box(
        modifier = modifier
            .clip(shape = containerShape)
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple()
            )
            .background(color = backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .height(height)
                .widthIn(min = height)
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            val textStyle = MaterialTheme.typography.bodyMedium
            if (icon != null) {
                val iconSize = if (text != null) {
                    12.dp
                } else {
                    with(LocalDensity.current) {
                        textStyle.fontSize.toDp()
                    }
                }

                Icon(
                    modifier = Modifier
                        .size(iconSize),
                    imageVector = icon,
                    contentDescription = "",
                    tint = contentColor
                )
            }

            if (icon != null && text != null) {
                Spacer(
                    modifier = Modifier
                        .width(LocalPaddings.current.textIconPadding)
                )
            }

            if (text != null) {
                Text(
                    text = text,
                    fontSize = textStyle.fontSize,
                    color = contentColor
                )
            }
        }
    }
}

@Preview
@Composable
fun TagListPreview() {
    LazyRow(
        modifier = Modifier
            .padding(top = 100.dp)
            .height(100.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(2) {
            Tag(
                onClick = {
                    println(it)
                },
                icon = Icons.Filled.Call
            )
        }

        items(3) {
            Tag(
                onClick = {
                    println(it)
                },
                icon = Icons.Filled.Call,
                text = "Nothing"
            )
        }
        items(5) {
            Tag(
                onClick = {
                    println(it)
                },
                isSelected = true,
                text = "Alllsda"
            )
        }
    }
}