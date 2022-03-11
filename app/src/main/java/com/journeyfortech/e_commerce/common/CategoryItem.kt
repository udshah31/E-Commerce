package com.journeyfortech.e_commerce.common


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.journeyfortech.e_commerce.data.model.Category
import com.journeyfortech.e_commerce.data.model.category


@ExperimentalMaterialApi
@Composable
fun CategoryItem(
    item: Category,
    onClick: () -> Unit,
) {
    val selectedItem by remember { mutableStateOf(category[0]) }
    Column(
        modifier = Modifier
            .wrapContentSize()
            .selectable(selected = selectedItem == item,
                onClick = {
                    onClick()
                }),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (selectedItem == item) {

            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp),
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, color = MaterialTheme.colors.secondary)
            ) {
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(5.dp),
                    shape = RoundedCornerShape(30.dp),
                    backgroundColor = Color.LightGray
                ) {
                    Icon(
                        painter = painterResource(id = item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(30.dp)
                    )
                }
            }

            Text(
                text = item.title,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold
            )
        } else {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp),
                shape = RoundedCornerShape(50.dp),
                border = BorderStroke(1.dp, color = MaterialTheme.colors.primary)
            ) {
                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(5.dp),
                    shape = RoundedCornerShape(30.dp),
                    backgroundColor = Color.LightGray
                ) {
                    Icon(
                        painter = painterResource(id = item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(30.dp)
                    )
                }
            }

            Text(
                text = item.title,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
        }

    }


}







