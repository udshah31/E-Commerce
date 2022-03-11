package com.journeyfortech.e_commerce.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddShoppingCart
import androidx.compose.material.icons.rounded.RemoveShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.journeyfortech.e_commerce.data.db.Favourite

@Composable
fun FavouriteItem(
    item: Favourite,
    isCart: Boolean,
    isCartLoading: Boolean,
    addOnCartClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(25.dp),
        elevation = 5.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {

            Surface(
                modifier = Modifier.padding(start = 5.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 5.dp
            ) {
                FavouriteImage(item.image!!)
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(top = 5.dp, start = 5.dp, end = 5.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = item.title!!, style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))

                /*Text(
                    text = "Size :" , style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Light
                )*/

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = "Rs.${item.price}",
                        style = MaterialTheme.typography.body1,
                    )

                    OutlinedButton(
                        shape = RoundedCornerShape(15.dp),
                        onClick = {
                            addOnCartClicked()
                        },
                        contentPadding = PaddingValues(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = MaterialTheme.colors.primary
                        )

                    ) {
                        if (isCartLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(24.dp),
                                strokeWidth = 2.dp
                            )
                        } else {
                            Icon(
                                imageVector = if (isCart) Icons.Rounded.RemoveShoppingCart else Icons.Rounded.AddShoppingCart,
                                contentDescription = "Localized description",
                                tint = MaterialTheme.colors.surface
                            )
                        }
                    }

                }

            }

        }

    }

}

@Composable
fun FavouriteImage(
    image: String,
    modifier: Modifier = Modifier,

    ) {
    val painter = rememberCoilPainter(request = image, fadeIn = true)

    Box(
        modifier
            .size(70.dp)
            .padding(5.dp),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
    }

}
