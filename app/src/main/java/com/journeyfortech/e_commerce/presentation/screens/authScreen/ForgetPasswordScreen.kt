package com.journeyfortech.e_commerce.presentation.screens.authScreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.common.ShowSnackBar
import kotlinx.coroutines.launch


@Composable
fun ForgetPasswordScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    var email by remember { mutableStateOf("") }
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()


    Scaffold(modifier = Modifier
        .fillMaxWidth(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Transparent),
                title = {
                    Text(
                        text = "Forget Password",
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.onSurface,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 0.dp
            )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Forget Password ?",
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Retrieve Your Password",
                style = MaterialTheme.typography.h4,
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        "Email",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold
                    )
                },
                placeholder = {
                    Text(
                        "Enter Email",
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.Bold
                    )
                },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.LightGray, textColor = Color.Black,
                    focusedBorderColor = Color.Black, unfocusedBorderColor = Color.LightGray
                ),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .layoutId("email"),
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .layoutId("signIn_btn"),
                shape = RoundedCornerShape(10.dp), elevation = ButtonDefaults.elevation(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary
                ),
                onClick = {
                    if (email.isEmpty()) {
                        scope.launch {
                            snackBarHostState.showSnackbar(
                                message = "Please Enter Valid Email And Password!!!",
                                actionLabel = null,
                                duration = SnackbarDuration.Short
                            )
                        }
                    } else {
                        navController.navigate("home") {
                            popUpTo("forget")
                        }
                    }
                }
            ) {
                Text(
                    text = "Submit",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.surface,
                    modifier = Modifier.padding(10.dp),
                )
            }

        }

        ShowSnackBar(snackBarHostState = snackBarHostState)

    }

}