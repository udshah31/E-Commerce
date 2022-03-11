package com.journeyfortech.e_commerce.presentation.screens.authScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import com.journeyfortech.e_commerce.common.ShowSnackBar
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    navController: NavController
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val snackBarHostState = remember { SnackbarHostState() }
    val isChecked = remember {
        mutableStateOf(false)
    }

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

                val createNewAccountTitle = createRefFor("create_new_account_title")
                val subTitle = createRefFor("subtitle")
                val fullNameBox = createRefFor("full_name")
                val emailBox = createRefFor("email")
                val phoneNumberBox = createRefFor("phone_number")
                val passwordBox = createRefFor("password")
                val checkBox = createRefFor("term_cond")
                val signUpBtn = createRefFor("signUp_btn")
                val haveAccountTv = createRefFor("have_account_text")

                constrain(createNewAccountTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }

                constrain(subTitle) {
                    top.linkTo(createNewAccountTitle.bottom, margin = 5.dp)
                    start.linkTo(createNewAccountTitle.start)
                    end.linkTo(createNewAccountTitle.end)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }

                constrain(fullNameBox) {
                    top.linkTo(subTitle.bottom, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(emailBox) {
                    top.linkTo(fullNameBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(phoneNumberBox) {
                    top.linkTo(emailBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(passwordBox) {
                    top.linkTo(phoneNumberBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(checkBox) {
                    top.linkTo(passwordBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(signUpBtn) {
                    top.linkTo(checkBox.bottom, margin = 10.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }

                constrain(haveAccountTv) {
                    top.linkTo(signUpBtn.bottom, margin = 5.dp)
                    start.linkTo(signUpBtn.start)
                    end.linkTo(signUpBtn.end)
                    width = Dimension.wrapContent
                    height = Dimension.wrapContent
                }


            }

            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier
                        .layoutId("create_new_account_title"),
                    text = "Create new account",
                    style = MaterialTheme.typography.h3,
                    letterSpacing = 1.5.sp,
                )



                Text(
                    modifier = Modifier
                        .layoutId("subtitle"),
                    text = "Please fill in the form to continue",
                    style = MaterialTheme.typography.h4,
                    letterSpacing = 1.5.sp
                )


                OutlinedTextField(
                    value = fullName,
                    onValueChange = { fullName = it },
                    label = {
                        Text(
                            "Full Name",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    placeholder = {
                        Text(
                            "Enter Full Name",
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
                        .layoutId("full_name"),
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
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = {
                        Text(
                            "Phone Number",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    placeholder = {
                        Text(
                            "Enter Phone Number",
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = Color.LightGray, textColor = Color.Black,
                        focusedBorderColor = Color.Black, unfocusedBorderColor = Color.LightGray
                    ),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .layoutId("phone_number"),
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
                        val image = if (passwordVisible) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(20.dp), imageVector = image,
                                contentDescription = "",
                                tint = Color.LightGray
                            )
                        }
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .layoutId("password"),
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .layoutId("term_cond"),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(checked = isChecked.value, onCheckedChange = { checked ->
                        isChecked.value = checked
                    })

                    Spacer(modifier = Modifier.width(5.dp))

                    val annotatedText = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(color = Color.LightGray)
                        ) {
                            append("Lorem ipsum is simply dummy text of the printing and typesetting industry.")
                        }
                        withStyle(
                            style = SpanStyle(color = MaterialTheme.colors.primary)
                        ) {
                            append("Term And Conditions")
                        }
                    }

                    Text(
                        text = annotatedText,
                        style = MaterialTheme.typography.overline
                    )

                }


                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .layoutId("signUp_btn"),
                    shape = RoundedCornerShape(10.dp), elevation = ButtonDefaults.elevation(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary
                    ),
                    onClick = {
                        if (fullName.isEmpty() && email.isEmpty() && phoneNumber.isEmpty() && password.isEmpty()) {
                            scope.launch {
                                snackBarHostState.showSnackbar(
                                    message = "Please Enter Full Name, Email, Phone Number And Password!!!",
                                    actionLabel = null,
                                    duration = SnackbarDuration.Short
                                )

                            }
                        } else {
                            navController.navigate("login") {
                                popUpTo("register")
                            }
                        }
                    }
                ) {
                    Text(
                        text = "REGISTER",
                        style = MaterialTheme.typography.button,
                        modifier = Modifier.padding(10.dp),
                        letterSpacing = 1.5.sp,
                        color = MaterialTheme.colors.surface
                    )
                }

                val annotatedText = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = Color.LightGray)
                    ) {
                        append("Have an Account?")
                    }
                    withStyle(
                        style = SpanStyle(color = MaterialTheme.colors.primary)
                    ) {
                        append("Sign In")
                    }
                }


                ClickableText(
                    text = annotatedText,
                    modifier = Modifier
                        .layoutId("have_account_text"),
                    onClick = {
                        navController.navigate("login") {
                            popUpTo("register")
                        }
                    }

                )

            }

        }


    }
    ShowSnackBar(snackBarHostState = snackBarHostState)
}


