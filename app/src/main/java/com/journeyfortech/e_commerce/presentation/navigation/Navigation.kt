package com.journeyfortech.e_commerce.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.journeyfortech.e_commerce.presentation.navigation.route.LeafScreen
import com.journeyfortech.e_commerce.presentation.navigation.route.RootScreen
import com.journeyfortech.e_commerce.presentation.screens.account.*
import com.journeyfortech.e_commerce.presentation.screens.authScreen.ForgetPasswordScreen
import com.journeyfortech.e_commerce.presentation.screens.authScreen.LoginScreen
import com.journeyfortech.e_commerce.presentation.screens.authScreen.RegisterScreen
import com.journeyfortech.e_commerce.presentation.screens.cart.CartScreen
import com.journeyfortech.e_commerce.presentation.screens.categories.CategoryScreen
import com.journeyfortech.e_commerce.presentation.screens.detail.DetailScreen
import com.journeyfortech.e_commerce.presentation.screens.explore.ExploreScreen
import com.journeyfortech.e_commerce.presentation.screens.favourite.FavouriteScreen
import com.journeyfortech.e_commerce.presentation.screens.home.HomeScreen
import com.journeyfortech.e_commerce.presentation.screens.searchScreen.SearchScreen
import com.journeyfortech.e_commerce.presentation.screens.startup.StartUpScreen
import kotlinx.coroutines.InternalCoroutinesApi


@InternalCoroutinesApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun Navigation(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = RootScreen.Home.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(RootScreen.Home.route) {
            HomeScreen(navController = navHostController)
        }

        composable(LeafScreen.LoginScreen.route) {
            LoginScreen(navController = navHostController)
        }

        composable(LeafScreen.RegisterScreen.route) {
            RegisterScreen(navController = navHostController)
        }

        composable(LeafScreen.ForgetPasswordScreen.route) {
            ForgetPasswordScreen(navController = navHostController)
        }

        composable(RootScreen.Home.route) {
            HomeScreen(navController = navHostController)
        }

        composable(RootScreen.Explore.route) {
            ExploreScreen(navController = navHostController)
        }

        composable(RootScreen.Favourite.route) {
            FavouriteScreen(navController = navHostController)
        }

        composable(RootScreen.Account.route) {
            AccountScreen(navController = navHostController)
        }

        composable(LeafScreen.CartScreen.route) {
            CartScreen(navController = navHostController)
        }

        composable(LeafScreen.SearchScreen.route) {
            SearchScreen(navController = navHostController)
        }

        composable(LeafScreen.DetailScreen.route) {
            DetailScreen(navController = navHostController)
        }

        composable(LeafScreen.CategoryScreen.route) {
            CategoryScreen(navController = navHostController)
        }

        composable(LeafScreen.AccountInformationScreen.route) {
            AccountInformationScreen(navController = navHostController)
        }

        composable(LeafScreen.PrivacyPolicyScreen.route) {
            PrivacyPolicyScreen(navController = navHostController)
        }

        composable(LeafScreen.ContactUsScreen.route) {
            ContactUsScreen(navController = navHostController)
        }

        composable(LeafScreen.ReportIssueScreen.route) {
            ReportIssueScreen(navController = navHostController)
        }

        composable(LeafScreen.HelpCenterScreen.route) {
            HelpCenterScreen(navController = navHostController)
        }

        composable(LeafScreen.TermConditionScreen.route) {
            TermConditionScreen(navController = navHostController)
        }
        composable(LeafScreen.MyOrdersScreen.route) {
            MyOrdersScreen(navController = navHostController)
        }
    }
}