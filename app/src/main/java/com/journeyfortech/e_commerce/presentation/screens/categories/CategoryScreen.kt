package com.journeyfortech.e_commerce.presentation.screens.categories

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.common.CategoryItem
import com.journeyfortech.e_commerce.data.model.category
import com.journeyfortech.e_commerce.presentation.screens.home.HomeTopAppBar

@OptIn(ExperimentalMaterialApi::class, androidx.compose.foundation.ExperimentalFoundationApi::class)
@Composable
fun CategoryScreen(
    navController: NavController
) {
    val scrollState = rememberLazyListState()

    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            HomeTopAppBar(
                title = "Categories",
                onClicked = {
                navController.navigate("search")
            })
        }
    ) {
        val constraintSet = ConstraintSet {
            val category = createRefFor("category")
            val categoryItem = createRefFor("cat_items")

            constrain(category) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }

            constrain(categoryItem) {
                top.linkTo(parent.top)
                start.linkTo(category.end)
                end.linkTo(parent.end)
                width = Dimension.preferredWrapContent
                height = Dimension.wrapContent
            }
        }

        ConstraintLayout(
            constraintSet,
            modifier = Modifier.wrapContentSize()
        ) {

            LazyColumn(
                modifier = Modifier
                    .layoutId("category"),
                state = scrollState
            ) {
                items(category.size) { item ->
                    CategoryItem(
                        item = category[item],
                        onClick = { category[item].id }
                    )
                }

            }

            LazyVerticalGrid(
                cells = GridCells.Fixed(3),
                modifier = Modifier
                    .layoutId("cat_items"),
                state = scrollState
            ) {
                items(category.size) { item ->
                    CategoryItem(item = category[item],
                        onClick = {

                        }
                    )
                }
            }

        }

    }
}


