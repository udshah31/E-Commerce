package com.journeyfortech.e_commerce.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun NormalTopAppBar(
    title: String
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = {
            Text(
                text = title, style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.Bold
            )
        },
        backgroundColor = Color.White,
        elevation = 0.dp
    )
}