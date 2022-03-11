package com.journeyfortech.e_commerce.presentation.screens.account

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.presentation.screens.cart.CartScreenTopAppBar

@Composable
fun AccountInformationScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            CartScreenTopAppBar(
                title = "Account Information",
                upPressed = { navController.popBackStack() })
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Name",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row {
                        Text(
                            text = "Not Set",
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                    }
                }
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Change Password",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Add Mobile",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row {
                        Text(
                            text = "Not Set",
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Change Email",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row {
                        Text(
                            text = "Not Set",
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Gender",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row {
                        Text(
                            text = "Not Set",
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Birthday",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row {
                        Text(
                            text = "Not Set",
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountInfoUi() {
}