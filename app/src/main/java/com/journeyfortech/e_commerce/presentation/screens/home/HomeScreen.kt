package com.journeyfortech.e_commerce.presentation.screens.home


import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.journeyfortech.e_commerce.common.*
import com.journeyfortech.e_commerce.data.model.category
import com.journeyfortech.e_commerce.data.model.offers
import com.journeyfortech.e_commerce.data.model.product.ProductResponseItem
import com.journeyfortech.e_commerce.data.model.slider
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@InternalCoroutinesApi
@ExperimentalFoundationApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val justForYou = viewModel.products.collectAsState().value

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HomeTopAppBar(title = "Sasto Bazar", onClicked = {
                navController.navigate("search")
            })
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {

            item {
                Slider()
                Category()
                Offers()
                MostPopular(viewModel, navController)
                JustForYou()

            }
            when (justForYou) {
                is Resource.Success -> {
                    val itemCount = if (justForYou.data!!.size % 2 == 0) {
                        justForYou.data!!.size / 2
                    } else {
                        justForYou.data!!.size / 2 + 1
                    }
                    items(itemCount) { item ->
                        JustForRow(rowIndex = item, list = justForYou.data!!)
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
fun Slider() {
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
                SliderItem(slider[page])

            }


        }

        HorizontalPagerIndicator(
            pagerState = pageState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            indicatorShape = RoundedCornerShape(50.dp),
            activeColor = Black,
            inactiveColor = Gray
        )

    }
}


@ExperimentalMaterialApi
@Composable
fun Category(
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 10.dp, end = 8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ) {
            Text(
                text = "Categories", style = MaterialTheme.typography.subtitle1,
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "View All", style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold
                )
                Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
            }

        }
        LazyRow {
            items(category.size) { item ->
                CategoryItem(item = category[item],
                    onClick = {})
            }
        }
    }

}

@ExperimentalPagerApi
@Composable
fun Offers(

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 10.dp, end = 8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ) {
            Text(
                text = "Offers", style = MaterialTheme.typography.subtitle1,
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "View All", style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold
                )
                Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
            }

        }
        LazyRow {
            items(offers.size) { item ->
                OfferItem(item = offers[item])
            }
        }
    }
}

@InternalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun MostPopular(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
    scrollRow: LazyListState = rememberLazyListState()
) {
    val product = viewModel.products.collectAsState().value
    when (product) {
        is Resource.Success -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 10.dp, end = 8.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                ) {
                    Text(
                        text = "Most Popular", style = MaterialTheme.typography.subtitle1,
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "View All", style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                    }
                }
                LazyRow(
                    state = scrollRow,
                ) {
                    items(
                        count = product.data!!.size
                    ) { item ->
                        ProductItem(
                            item = product.data!![item],
                            navController = navController,
                            isFavourite = viewModel.isFavorite == true,
                            isFavouriteLoading = viewModel.isFavoriteLoading,
                            onFavouriteClicked = {
                                viewModel.onFavouriteClicked(product.data!![item])
                                viewModel.isFav(product.data!![item].id)
                            }
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

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun JustForYou() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 10.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Just For You", style = MaterialTheme.typography.subtitle1,
        )
    }

}

@Composable
fun JustForRow(
    rowIndex: Int,
    list: List<ProductResponseItem>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 10.dp, end = 8.dp)
    ) {
        Row {
            JustForYouItem(
                item = list[rowIndex * 2],
                modifier = Modifier.weight(1f)
            )
            if (list.size >= rowIndex * 2 * 2) {
                JustForYouItem(
                    item = list[rowIndex * 2 + 1],
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

