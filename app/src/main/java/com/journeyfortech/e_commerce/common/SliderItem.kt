package com.journeyfortech.e_commerce.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journeyfortech.e_commerce.data.model.Slider

@Composable
fun SliderItem(
    item: Slider,
    modifier: Modifier = Modifier
) {

    Box(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface)
            .clip(shape = RectangleShape)
    ) {
        Box(
            modifier
                .fillMaxWidth(0.65f)
                .fillMaxHeight()
                .clip(CutCornerShape(bottomEnd = 500f))
                .background(MaterialTheme.colors.primary)
        )
        Image(
            painter = painterResource(item.image),
            contentDescription = "",
            modifier = Modifier.padding(
                top = 3.dp,
                start = 12.dp
            )
        )

        Column(
            modifier.align(Alignment.CenterEnd)
        ) {
            Text(
                text = item.discount,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        bottom = 10.dp,
                        end = 18.dp
                    ),
                fontSize = 23.sp
            )

            Text(
                text = item.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = 23.dp,
                        end = 18.dp
                    )
            )
        }
    }


}