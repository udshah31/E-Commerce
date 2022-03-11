package com.journeyfortech.e_commerce.common


import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProductRatingBarAndReviews(
    rating: Int,
    reviews: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        for (i in 1..5) {
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                tint = if (i<= rating) Color.Yellow else Color.LightGray
            )
        }
        Spacer(modifier = Modifier.width(3.dp))

        Text(
            text = "(${reviews} Reviews)",
            style = MaterialTheme.typography.overline,
            color = Color.LightGray
        )

    }

}

@Preview(showBackground = true)
@Composable
fun ProductRatingUi() {
    ProductRatingBarAndReviews(rating = 3, reviews = "222")
}