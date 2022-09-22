package com.pm.ecogarden.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)
val StarColor = Color(0xFFFFC94D)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

val EcoGreen = Color(0xFF97D54E)
val ShopButtonBackground = Color(0xFFFAEDCD)
val ButtonContent = Color(0xFFCFA170)
val StartGradientBackground = Color(0xFFFFFFE5)
val EndGradientBackground = Color(0xFFCEE7BD)
val MildBackground = Color(0xFFFFF9E1)
val MenuBackground = Color(0xFFEEE4CC)
val MenuBackgroundBorder = Color(0xFFCBCBCB)
val BasketBackground = Color(0xFFDEF0C4)

val ErrorRed = Color(0xFFFF6C60)
val InfoGreen = Color(0xFF00C096)
val LoadingBlue = Color(0xFF1A73E8)

val ColorScheme.topAppBarContentColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else Color.LightGray

val ColorScheme.topAppBarBackgroundColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) ShimmerMediumGray else Color.Black