package com.journeyfortech.e_commerce.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState
import com.journeyfortech.e_commerce.data.model.product.ProductResponseItem

@Composable
fun JustForYouItem(
    item: ProductResponseItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier
            .wrapContentSize()
            .padding(8.dp),
        shape = RectangleShape,
        elevation = 5.dp
    ) {

        val constraints = ConstraintSet {
            val off = createRefFor("off")
            val favourite = createRefFor("favourite")
            val image = createRefFor("image")
            val content = createRefFor("content")

            constrain(off) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
            constrain(favourite) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
            constrain(image) {
                top.linkTo(off.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }

            constrain(content) {
                top.linkTo(image.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }

        }
        ConstraintLayout(
            constraints,
            modifier = Modifier.wrapContentSize()
        ) {

            Surface(
                modifier = Modifier
                    .layoutId("off")
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,

                ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "30% OFF",
                    style = MaterialTheme.typography.body1
                )
            }

            /*IconButton(
                modifier = Modifier
                    .layoutId("favourite"),
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = ""
                )
            }*/

            JustForYouImage(
                modifier = Modifier.layoutId("image"),
                image = item.image
            )


            Column(
                modifier = Modifier
                    .layoutId("content")
                    .padding(5.dp)
            ) {
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(3.dp))
                ProductRatingBarAndReviews(
                    rating = item.rating.rate.toInt(),
                    reviews = item.rating.count.toString()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        Text(
                            text = "Rs." + item.price,
                            style = MaterialTheme.typography.caption
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "Rs." + "200",
                            style = MaterialTheme.typography.caption,
                            textDecoration = TextDecoration.LineThrough,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Surface(
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(15.dp),
                        elevation = 5.dp,
                        color = MaterialTheme.colors.primary
                    )
                    {
                        Text(
                            modifier = Modifier.padding(3.dp),
                            text = "SHOP NOW",
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }

                }

            }


        }

    }
}

@Composable
fun JustForYouImage(
    modifier: Modifier = Modifier,
    image: String
) {
    val painter = rememberCoilPainter(request = image, fadeIn = true)

    Box(
        modifier
            .size(185.dp)
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        when (painter.loadState) {
            is ImageLoadState.Loading -> {
                CircularProgressIndicator(
                    modifier
                        .size(24.dp)
                        .align(
                            Alignment.Center
                        ),
                    strokeWidth = 2.dp
                )
            }
            is ImageLoadState.Error -> {
                PlaceholderImage(
                    modifier.matchParentSize()
                )
            }
            else -> Unit
        }
    }

}


