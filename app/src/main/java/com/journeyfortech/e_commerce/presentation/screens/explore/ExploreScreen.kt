package com.journeyfortech.e_commerce.presentation.screens.explore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.common.HomeCategoryItem
import com.journeyfortech.e_commerce.data.model.category
import com.journeyfortech.e_commerce.presentation.screens.home.HomeTopAppBar

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun ExploreScreen(
    navController: NavController
) {
    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            HomeTopAppBar(title = "Explore", onClicked = {
                navController.navigate("search")
            })
        }
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = Modifier
                .layoutId("cat_items"),
            state = rememberLazyListState()
        ) {
            items(category.size) { item ->
                HomeCategoryItem(item = category[item],
                    onClick = {

                    }
                )
            }
        }
    }
}