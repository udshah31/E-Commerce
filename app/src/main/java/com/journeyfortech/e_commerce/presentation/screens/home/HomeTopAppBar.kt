package com.journeyfortech.e_commerce.presentation.screens.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun HomeTopAppBar(
    title: String,
    onClicked: () -> Unit
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
        actions = {
            IconButton(
                onClick = { onClicked() }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "",
                    tint = MaterialTheme.colors.onSecondary,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        },
        backgroundColor = Color.White,
        elevation = 0.dp
    )
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun HomeTopAppBarUi() {
    HomeTopAppBar(title = "Home", onClicked = {})
}

