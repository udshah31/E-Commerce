package com.journeyfortech.e_commerce.presentation.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.R
import com.journeyfortech.e_commerce.common.CartItem
import com.journeyfortech.e_commerce.common.Resource

@ExperimentalMaterialApi
@Composable
fun CartScreen(
    navController: NavController,
    viewModel: CartViewModel = hiltViewModel()
) {
    val scrollState = rememberLazyListState()
    val result = viewModel.state.collectAsState().value

    when (result) {
        is Resource.Success -> {
            Scaffold(modifier = Modifier.fillMaxSize(),
                topBar = {
                    CartScreenTopAppBar(title = "Cart",
                        upPressed = {
                            navController.popBackStack()
                        })
                },
                bottomBar = {
                    if (result.data!!.isNotEmpty()) {
                        TotalAmount()
                    }

                }
            ) {
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
                                painter = painterResource(id = R.drawable.empty_cart),
                                contentDescription = "",
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Cart Empty",
                                style = MaterialTheme.typography.body1,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                } else {
                    LazyColumn(
                        state = scrollState
                    ) {
                        itemsIndexed(
                            items = result.data!!,
                            key = { _, item ->
                                item.hashCode()
                            }
                        ) { _, item ->
                            val state = rememberDismissState(
                                confirmStateChange = {
                                    if (it == DismissValue.DismissedToStart) {
                                        viewModel.deleteCartById(item.id!!)
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
                                    CartItem(
                                        item = item,
                                        quantity = viewModel.quantity.toString() ,
                                        onClickAdd = {
                                            viewModel.quantityAdded()
                                        },
                                        onClickRemove = {
                                            viewModel.quantityRemoved()
                                        }
                                    )
                                }, directions = setOf(DismissDirection.EndToStart)
                            )
                        }
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

@Composable
fun TotalAmount(
    viewModel: CartViewModel = hiltViewModel()
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Subtotal",
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Rs.${viewModel.subTotal}",
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )

            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Delivery Charge",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Rs.${viewModel.delivery}",
                    style = MaterialTheme.typography.body2,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )

            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "Rs.${viewModel.total}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.ExtraBold
                )

            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { }
            ) {
                Text(
                    text = "PROCEED TO CHECKOUT",
                    style = MaterialTheme.typography.button
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun TotalAmountUi() {
    TotalAmount()
}


