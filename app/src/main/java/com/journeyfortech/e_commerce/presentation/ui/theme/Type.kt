package com.journeyfortech.e_commerce.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.journeyfortech.e_commerce.R

// Set of Material typography styles to start with
val OpenSans = FontFamily(
    Font(R.font.open_sans_regular, FontWeight.W300),
    Font(R.font.open_sans_bold, FontWeight.W400),
    Font(R.font.open_sans_light, FontWeight.W500),
    Font(R.font.open_sans_medium, FontWeight.W600),
)

val openSansTypography = Typography(
    h1 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W400,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    h4 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W500,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),

    h6 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = OpenSans,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),

    subtitle2 = TextStyle(
        fontFamily = OpenSans,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),

    body1 = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = OpenSans,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    button = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),
    caption = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
    overline = TextStyle(
        fontFamily = OpenSans,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp
    ),
)