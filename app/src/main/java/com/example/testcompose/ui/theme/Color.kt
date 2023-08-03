package com.example.testcompose.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val YellowSeraphim = Color(0xFFD3A910)
val BlueUef = Color(0xFF1681CF)
val GreenAeon = Color(0xFF0B9024)
val RedCybran = Color(0xFFDB2912)

val YellowSeraphim1 = Color(0xFFFFC107)
val BlueUef2 = Color(0xFF2196F3)
val GreenAeon3 = Color(0xFF4CAF50)
val RedCybran4 = Color(0xFFBA003F)

val GrayG = Color(0xFF2F3136)
val GrayLightG = Color(0xFF36393f)

val ToxicGreen = Color(0xFF6EA52F)
val White = Color(0xFFFFFFFF)

val GrayL = Color(0xFFDADADA)
val GrayM = Color(0xFF98989C)

val GrayLight = Color(0xFFaFB1B3)
val GrayDark = Color(0xFF2B2B2B)
val Gray = Color(0xFF3C3F41)

data class Colors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val primaryTintColor: Color,
    val secondaryTintColor: Color,
    val primaryIconColor: Color,
    val secondaryIconColor: Color,
)

val darkPalette = Colors(
    primaryBackground = GrayDark,
    secondaryBackground = Gray,
    primaryTextColor = White,
    secondaryTextColor = GrayLight,
    primaryTintColor = ToxicGreen,
    secondaryTintColor = BlueUef,
    primaryIconColor = White,
    secondaryIconColor = GrayLight
)