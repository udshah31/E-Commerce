package com.journeyfortech.e_commerce.presentation.screens.authScreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.journeyfortech.e_commerce.R
import com.journeyfortech.e_commerce.common.ShowSnackBar
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val snackBarHostState = remember { SnackbarHostState() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()

        ) {

            val constraints = ConstraintSet {

                val welcomeTitle = createRefFor("welcome_title")
                val subTitle = createRefFor("subtitle")
                val emailBox = createRefFor("email")
                val passwordBox = createRefFor("password")
                val forgetTv = createRefFor("forget_text")
                val signInBtn = createRefFor("signIn_btn")
                val signWithOther = createRefFor("other_account")
                val noAccountTv = createRefFor("no_account_text")

                constrain(welcomeTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }

                constrain(subTitle) {
                    top.linkTo(welcomeTitle.bottom, margin = 5.dp)
                    start.linkTo(welcomeTitle.start)
                    end.linkTo(welcomeTitle.end)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }

                constrain(emailBox) {
                    top.linkTo(subTitle.bottom, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(passwordBox) {
                    top.linkTo(emailBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(forgetTv) {
                    top.linkTo(passwordBox.bottom)
                    end.linkTo(passwordBox.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(signInBtn) {
                    top.linkTo(forgetTv.bottom, margin = 25.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(signWithOther) {
                    top.linkTo(signInBtn.bottom, margin = 5.dp)
                    start.linkTo(signInBtn.start)
                    end.linkTo(signInBtn.end)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }

                constrain(noAccountTv) {
                    top.linkTo(signWithOther.bottom, margin = 5.dp)
                    start.linkTo(signWithOther.start)
                    end.linkTo(signWithOther.end)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }
            }

            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier
                        .layoutId("welcome_title"),
                    text = "Welcome Back!",
                    style = MaterialTheme.typography.h3,
                    letterSpacing = 1.5.sp,
                )


                Text(
                    modifier = Modifier
                        .layoutId("subtitle"),
                    text = "Please sign in to your account",
                    style = MaterialTheme.typography.h4,
                    letterSpacing = 1.5.sp
                )

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

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            "Password",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    placeholder = {
                        Text(
                            "Enter Password",
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = Color.LightGray, textColor = Color.Black,
                        focusedBorderColor = Color.Black, unfocusedBorderColor = Color.LightGray
                    ),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        IconButton(
                            onClick = { passwordVisible = !passwordVisible }
                        ) {
                            Icon(
                                imageVector = image,
                                contentDescription = "",
                                tint = Color.LightGray,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(20.dp)
                            )
                        }
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .layoutId("password"),
                )

                Text(
                    modifier = Modifier
                        .layoutId("forget_text")
                        .clickable { navController.navigate("forget") },
                    text = "Forget Password?",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
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
                        if (email.isEmpty() && password.isEmpty()) {
                            scope.launch {
                                snackBarHostState.showSnackbar(
                                    message = "Please Enter Valid Email And Password!!!",
                                    actionLabel = null,
                                    duration = SnackbarDuration.Short
                                )
                            }
                        } else {
                            navController.navigate("home") {
                                popUpTo("login")
                            }
                        }
                    }
                ) {
                    Text(
                        text = "LOGIN",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.surface,
                        modifier = Modifier.padding(10.dp),
                    )
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .layoutId("other_account"),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.google_plus),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                }


                val annotatedText = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = Color.LightGray)
                    ) {
                        append("Don't have an Account? ")
                    }
                    withStyle(
                        style = SpanStyle(color = MaterialTheme.colors.primary)
                    ) {
                        append("Sign Up")
                    }
                }

                ClickableText(
                    text = annotatedText,
                    modifier = Modifier
                        .layoutId("no_account_text"),
                    onClick = {
                        navController.navigate("register")
                    }

                )


            }

        }

    }

    ShowSnackBar(snackBarHostState = snackBarHostState)
}

