package com.example.testcompose.ui.theme


import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun FafCalculatorComposeTheme(
    content: @Composable () -> Unit
) {
    rememberSystemUiController().setSystemBarsColor(color = Gray)

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