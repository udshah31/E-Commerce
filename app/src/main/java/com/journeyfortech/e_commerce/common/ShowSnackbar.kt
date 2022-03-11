package com.journeyfortech.e_commerce.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun ShowSnackBar(
    snackBarHostState: SnackbarHostState
) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val snackbar = createRef()
        SnackbarHost(modifier = Modifier.constrainAs(snackbar) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        },
            hostState = snackBarHostState,
            snackbar = {
                Snackbar( modifier = Modifier
                    .padding(4.dp),
                    shape = RoundedCornerShape(4.dp),
                    action = {
                        Text(
                            text = snackBarHostState.currentSnackbarData?.actionLabel?:"",
                            style = TextStyle(color = Color.White)
                        )
                    }
                ) {
                    Text(snackBarHostState.currentSnackbarData?.message?: "")
                }
            }
        )

    }

}