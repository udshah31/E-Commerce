package com.journeyfortech.e_commerce.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color


@Composable
fun PlaceholderImage(
    modifier: Modifier = Modifier
) {
    Box(
        modifier.background(
            shape = MaterialTheme.shapes.medium,
            color = Color.LightGray
        ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Filled.Error,
            contentDescription = "",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.scale(2f)
        )
    }
}