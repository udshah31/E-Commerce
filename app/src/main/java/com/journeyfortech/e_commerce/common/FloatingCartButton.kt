package com.journeyfortech.e_commerce.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FloatingCartButton(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = { onClick() },
        shape = RoundedCornerShape(50),
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(bottom = 6.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.ShoppingCart,
            contentDescription = null
        )
    }
}