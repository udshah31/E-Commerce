package com.journeyfortech.e_commerce.presentation.screens.favourite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.R
import com.journeyfortech.e_commerce.common.FavouriteItem
import com.journeyfortech.e_commerce.common.NormalTopAppBar
import com.journeyfortech.e_commerce.common.Resource

@ExperimentalMaterialApi
@Composable
fun FavouriteScreen(
    navController: NavController,
    favouriteViewModel: FavouriteViewModel = hiltViewModel()
) {
    val result = favouriteViewModel.fav.collectAsState().value
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NormalTopAppBar(title = "Favourite")
        }
    ) {

        when (result) {
            is Resource.Success -> {
                if (result.data!!.isNullOrEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                modifier = Modifier.size(200.dp, 150.dp),
                                painter = painterResource(id = R.drawable.no_favourite),
                                contentDescription = "",
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "No Data Available",
                                style = MaterialTheme.typography.body1,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                } else {
                    LazyColumn {
                        itemsIndexed(
                            items = result.data!!,
                            key = { _, item ->
                                item.hashCode()
                            }
                        ) { _, item ->
                            val state = rememberDismissState(
                                confirmStateChange = {
                                    if (it == DismissValue.DismissedToStart) {
                                        favouriteViewModel.deleteFavById(item.id!!)
                                    }
                                    true
                                }
                            )
                            SwipeToDismiss(
                                state = state,
                                background = {
                                    val color = when (state.dismissDirection) {
                                        DismissDirection.StartToEnd -> Color.Transparent
                                        DismissDirection.EndToStart -> Color.Red
                                        null -> Color.Transparent
                                    }
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(color)
                                            .padding(8.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Rounded.Delete,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.align(Alignment.CenterEnd)
                                        )
                                    }
                                },
                                dismissContent = {
                                    FavouriteItem(
                                        item = item,
                                        isCart = favouriteViewModel.isCart == true,
                                        isCartLoading = favouriteViewModel.isCartLoading,
                                        addOnCartClicked = {
                                            favouriteViewModel.onCartClicked()
                                        }
                                    )
                                }, directions = setOf(DismissDirection.EndToStart)
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
}