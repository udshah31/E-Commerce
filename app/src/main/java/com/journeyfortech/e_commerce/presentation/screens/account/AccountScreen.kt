package com.journeyfortech.e_commerce.presentation.screens.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.common.NormalTopAppBar

@ExperimentalMaterialApi
@Composable
fun AccountScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            NormalTopAppBar(title = "Account")
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(top = 10.dp),
                        shape = RoundedCornerShape(80.dp),
                        elevation = 5.dp,
                    ) {
                        Image(
                            imageVector = Icons.Rounded.Person,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(5.dp)
                                .size(90.dp)
                        )

                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Sign In",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Set Your Profile",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

            }

            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
                onClick = { navController.navigate("accountInformation") }

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Account Information",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
                onClick = { navController.navigate("myOrders") }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "My Orders",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
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
                        text = "About Shop",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
                onClick = { navController.navigate("term_condition") }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Terms & Condition",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
                onClick = { navController.navigate("helpCenter") }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Help Center",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
                onClick = { navController.navigate("reportIssue") }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Report Issue",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
                onClick = { navController.navigate("contactUs") }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Contact Us",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RectangleShape,
                elevation = 5.dp,
                onClick = { navController.navigate("privacyPolicy") }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Privacy Policy",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(imageVector = Icons.Rounded.ArrowForwardIos, contentDescription = null)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountUi() {

}