package com.journeyfortech.e_commerce.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.journeyfortech.e_commerce.data.model.Offer

@Composable
fun OfferItem(
    item: Offer
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
            .aspectRatio(2f)
            .clip(shape = RectangleShape)
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(275.dp, 150.dp)

        )
    }


}


