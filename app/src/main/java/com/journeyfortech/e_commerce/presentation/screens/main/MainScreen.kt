package com.journeyfortech.e_commerce.presentation.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.journeyfortech.e_commerce.common.FloatingCartButton
import com.journeyfortech.e_commerce.presentation.navigation.Navigation
import com.journeyfortech.e_commerce.presentation.navigation.bottomNav.BottomNavBar
import com.journeyfortech.e_commerce.presentation.navigation.route.LeafScreen
import com.journeyfortech.e_commerce.presentation.navigation.route.RootScreen
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@ExperimentalFoundationApi
@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val rootScreens = listOf(
        RootScreen.Home,
        RootScreen.Explore,
        RootScreen.Favourite,
        RootScreen.Account
    )

    val mainRoutes = listOf(
        LeafScreen.StartUpScreen,
        LeafScreen.DetailScreen,
        LeafScreen.LoginScreen,
        LeafScreen.RegisterScreen,
        LeafScreen.ForgetPasswordScreen,
        LeafScreen.CartScreen,
        LeafScreen.CategoryScreen,
        LeafScreen.SearchScreen,
        LeafScreen.AccountInformationScreen,
        LeafScreen.PrivacyPolicyScreen,
        LeafScreen.ContactUsScreen,
        LeafScreen.ReportIssueScreen,
        LeafScreen.HelpCenterScreen,
        LeafScreen.TermConditionScreen,
        LeafScreen.MyOrdersScreen
    ).map { it.route }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val showBottomBar = currentRoute !in mainRoutes


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar)
                BottomNavBar(navHostController = navController, items = rootScreens)
        },
        floatingActionButton = {
            if (showBottomBar)
                FloatingCartButton(onClick = { navController.navigate("cart") })
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Navigation(navHostController = navController)
    }
}