package com.journeyfortech.e_commerce.presentation.screens.searchScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.presentation.screens.cart.CartScreenTopAppBar

@Composable
fun SearchScreen(
    navController: NavController
) {

    val textState = remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CartScreenTopAppBar(title = "Search",
                upPressed = {
                    navController.popBackStack()
                })
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = textState.value,
                onValueChange = {},
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(text = "Search")
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.LightGray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )

        }

    }

}


