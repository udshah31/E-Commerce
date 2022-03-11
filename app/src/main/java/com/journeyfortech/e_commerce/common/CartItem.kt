package com.journeyfortech.e_commerce.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.journeyfortech.e_commerce.data.db.Cart

@Composable
fun CartItem(
    item: Cart,
    quantity: String,
    onClickRemove: () -> Unit,
    onClickAdd: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(25.dp),
        elevation = 5.dp
    ) {
        Row(
            verticalAlignment = CenterVertically,
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
                CartImage(item.image!!)
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = item.title!!, style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                /* Spacer(modifier = Modifier.height(5.dp))

                 Text(
                     text = "Size : 36", style = MaterialTheme.typography.body1,
                     fontWeight = FontWeight.Light
                 )*/

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text = "Rs.${item.price}",
                        style = MaterialTheme.typography.body1
                    )

                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        elevation = 3.dp,
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Row {
                            IconButton(
                                onClick = {
                                    onClickRemove()
                                },
                                modifier = Modifier.size(25.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Remove,
                                    contentDescription = "",
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = quantity,
                                style = MaterialTheme.typography.body1,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.align(CenterVertically)
                            )
                            Spacer(modifier = Modifier.width(5.dp))

                            IconButton(
                                onClick = {
                                    onClickAdd()
                                },
                                modifier = Modifier.size(25.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Add,
                                    contentDescription = ""
                                )
                            }

                        }

                    }

                }

            }

        }

    }

}

@Composable
fun CartImage(
    image: String
) {
    val painter = rememberCoilPainter(request = image, fadeIn = true)

    Box(
        modifier = Modifier
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

