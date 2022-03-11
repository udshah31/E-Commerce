  package com.journeyfortech.e_commerce.presentation.navigation.bottomNav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.journeyfortech.e_commerce.presentation.navigation.route.RootScreen

@Composable
fun BottomNavBar(
    navHostController: NavHostController,
    items: List<RootScreen>
) {

    BottomAppBar(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.primary,
        cutoutShape = RoundedCornerShape(50),
    ) {
        val navBackStackEntry = navHostController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination?.route

        items.forEach { rootScreen ->

            if (rootScreen == items[2]) {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f)
                )
            }

            BottomNavigationItem(
                modifier = Modifier
                    .weight(1f)
                    .background(MaterialTheme.colors.surface),
                icon = { Icon(imageVector = rootScreen.icon, contentDescription = null) },
                label = {
                    Text(
                        text = stringResource(id = rootScreen.label),
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold
                    )
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(0.4f),
                alwaysShowLabel = false,
                selected = currentDestination == rootScreen.route,
                onClick = {
                    navHostController.navigate(rootScreen.route) {
                        popUpTo(navHostController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )

        }

    }


}