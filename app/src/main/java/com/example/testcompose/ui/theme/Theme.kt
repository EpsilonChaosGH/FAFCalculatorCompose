package com.example.testcompose.ui.theme


import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf


@Composable
fun FafCalculatorComposeTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorProvider provides darkPalette,
        content = content
    )
}

object AppTheme {
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current
}

val LocalColorProvider = staticCompositionLocalOf<Colors> { error("no local provide") }