package com.journeyfortech.e_commerce.presentation.screens.account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.presentation.screens.cart.CartScreenTopAppBar

@Composable
fun ContactUsScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            CartScreenTopAppBar(title = "Contact Us", upPressed = { navController.popBackStack() })
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {

        }
    }

}