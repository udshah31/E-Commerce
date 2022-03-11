package com.journeyfortech.e_commerce.presentation.screens.detail


import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.journeyfortech.e_commerce.common.PlaceholderImage
import com.journeyfortech.e_commerce.common.ProductItem
import com.journeyfortech.e_commerce.common.RatingBar
import com.journeyfortech.e_commerce.common.Resource
import com.journeyfortech.e_commerce.data.model.slider
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@InternalCoroutinesApi
@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val singleProduct = viewModel.singleProduct.collectAsState().value
    Scaffold(
        topBar = {
            DetailPageTopAppBar(
                upPressed = { navController.popBackStack() },
                isFavourite = viewModel.isFavorite == true,
                isFavouriteLoading = viewModel.isFavoriteLoading,
                onFavouriteClicked = { viewModel.onFavouriteClicked() },
                isCart = viewModel.isCart == true,
                isCartLoading = viewModel.isCartLoading,
                addOnCartClicked = { viewModel.onCartClicked() })
        },
        bottomBar = {
            BottomButton(
                isCart = viewModel.isCart == true,
                isCartLoading = viewModel.isCartLoading,
                onCartClicked = { viewModel.onCartClicked() }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            when (singleProduct) {
                is Resource.Success -> {
                    val item = singleProduct.data
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())

                    ) {
                        DetailImageSlider()
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                            ) {
                                Text(
                                    text = item!!.title,
                                    style = MaterialTheme.typography.body1,
                                )

                                Spacer(modifier = Modifier.height(5.dp))
                                RatingBar(
                                    item.rating.rate.toInt(),
                                    item.rating.count.toString()
                                )
                                Spacer(modifier = Modifier.height(5.dp))
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
                                        style = MaterialTheme.typography.caption
                                    )
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    contentAlignment = Alignment.CenterStart
                                ) {

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.Start,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Rs.${item.price}",
                                            style = MaterialTheme.typography.body1,
                                        )

                                        Spacer(modifier = Modifier.width(15.dp))

                                        Text(
                                            text = "Rs. 200",
                                            style = MaterialTheme.typography.body2,
                                            fontWeight = FontWeight.Bold,
                                            textDecoration = TextDecoration.LineThrough
                                        )
                                    }

                                    Text(
                                        modifier = Modifier.align(alignment = Alignment.CenterEnd),
                                        text = "Available in Stock",
                                        style = MaterialTheme.typography.body1,
                                        fontWeight = FontWeight.Bold
                                    )

                                }
                                Spacer(modifier = Modifier.height(15.dp))
                                Text(
                                    text = "About",
                                    style = MaterialTheme.typography.body1,
                                )

                                Spacer(modifier = Modifier.height(15.dp))
                                Text(
                                    text = item.description,
                                    style = MaterialTheme.typography.body1,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Justify,
                                )

                                Spacer(modifier = Modifier.height(15.dp))

                                SimilarItems(navController, viewModel)

                                Spacer(modifier = Modifier.height(50.dp))

                            }
                        }
                    }


                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }

    }

}

@ExperimentalPagerApi
@Composable
fun DetailImageSlider() {
    val pageState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        LaunchedEffect(key1 = pageState.currentPage) {
            launch {
                delay(3000)
                with(pageState) {
                    val target = if (currentPage < pageCount - 1) currentPage + 1 else 0
                    tween<Float>(
                        500,
                        easing = FastOutSlowInEasing
                    )
                    animateScrollToPage(page = target)
                }
            }
        }
        HorizontalPager(
            count = slider.size,
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f),
                elevation = 5.dp,
            ) {
                DetailImage(image = page.toString())

            }


        }

        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            indicatorShape = RoundedCornerShape(50.dp),
            activeColor = Color.Black,
            inactiveColor = Color.Gray
        )

    }
}

@Composable
fun DetailImage(
    image: String
) {
    val painter = rememberCoilPainter(request = image, fadeIn = true)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentAlignment = Alignment.Center


    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        when (painter.loadState) {
            is ImageLoadState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(24.dp)
                        .align(
                            Alignment.Center
                        ),
                    strokeWidth = 2.dp
                )
            }
            is ImageLoadState.Error -> {
                PlaceholderImage(
                    modifier = Modifier.matchParentSize()
                )
            }
            else -> Unit
        }
    }
}


@InternalCoroutinesApi
@Composable
fun SimilarItems(
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val product = viewModel.products.collectAsState().value

    when (product) {
        is Resource.Success -> {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Similar Items",
                    style = MaterialTheme.typography.body1,
                )

                Spacer(modifier = Modifier.height(5.dp))

                LazyRow {
                    items(product.data!!.size) { item ->
                        ProductItem(
                            item = product.data!![item],
                            navController,
                            onFavouriteClicked = {},
                            isFavourite = false,
                            isFavouriteLoading = false
                        )
                    }
                }
            }
        }
        is Resource.Error -> {

        }

        is Resource.Loading -> {

        }
    }

}

@InternalCoroutinesApi
@Composable
fun BottomButton(
    isCart: Boolean,
    isCartLoading: Boolean,
    onCartClicked: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,

            ) {

            Button(
                modifier = Modifier.weight(1f),
                onClick = {

                },
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Gray,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Buy Now", style = MaterialTheme.typography.button)
            }

            Spacer(modifier = Modifier.width(5.dp))
            if (isCartLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp),
                    strokeWidth = 2.dp
                )
            } else {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        onCartClicked()
                    },
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (isCart) MaterialTheme.colors.primary else MaterialTheme.colors.secondaryVariant,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = if (isCart) "Already Exists" else "Add to Cart",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }
}






