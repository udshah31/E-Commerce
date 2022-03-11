package com.journeyfortech.e_commerce.presentation.navigation.route


import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.journeyfortech.e_commerce.R

sealed class RootScreen(
    val route: String,
    @StringRes val label: Int,
    val icon: ImageVector
) {
    object Home : RootScreen(
        route = "home",
        label = R.string.title_home,
        icon = Icons.Rounded.Home
    )

    object Explore : RootScreen(
        route = "explore",
        label = R.string.title_explore,
        icon = Icons.Rounded.Explore
    )

    object Favourite : RootScreen(
        route = "favourite",
        label = R.string.title_favourite,
        icon = Icons.Rounded.Favorite
    )

    object Account : RootScreen(
        route = "account",
        label = R.string.title_account,
        icon = Icons.Rounded.Person
    )
}

sealed class LeafScreen(
    val route: String
) {
    object StartUpScreen : LeafScreen("splash")

    object LoginScreen : LeafScreen("login")

    object RegisterScreen : LeafScreen("register")

    object ForgetPasswordScreen : LeafScreen("forget")

    object CartScreen : LeafScreen("cart")

    object CategoryScreen : LeafScreen("category")

    object SearchScreen : LeafScreen("search")

    object DetailScreen : LeafScreen("detail/{productId}")


    object AccountInformationScreen : LeafScreen("accountInformation")
    object PrivacyPolicyScreen : LeafScreen("privacyPolicy")
    object ContactUsScreen : LeafScreen("contactUs")
    object ReportIssueScreen : LeafScreen("reportIssue")
    object HelpCenterScreen : LeafScreen("helpCenter")
    object TermConditionScreen : LeafScreen("term_condition")
    object MyOrdersScreen : LeafScreen("myOrders")
}
