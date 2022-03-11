package com.journeyfortech.e_commerce.presentation.screens.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailPageTopAppBar(
    upPressed: () -> Unit,
    isFavourite: Boolean,
    isFavouriteLoading: Boolean,
    onFavouriteClicked: () -> Unit,
    isCart: Boolean,
    isCartLoading: Boolean,
    addOnCartClicked: () -> Unit

) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = {},
        navigationIcon = {
            IconButton(onClick = {
                upPressed()
            }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }, actions = {
            if (isCartLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp),
                    strokeWidth = 2.dp
                )
            } else {
                IconButton(
                    onClick = { addOnCartClicked() }
                ) {
                    Icon(
                        imageVector = if (isCart) Icons.Rounded.RemoveShoppingCart else Icons.Rounded.AddShoppingCart,
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }

            if (isFavouriteLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp),
                    strokeWidth = 2.dp
                )
            } else {
                IconButton(onClick = { onFavouriteClicked() }) {
                    Icon(
                        imageVector = if (isFavourite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )

                }
            }
        },
        backgroundColor = Color.White,
        elevation = 0.dp
    )

}


