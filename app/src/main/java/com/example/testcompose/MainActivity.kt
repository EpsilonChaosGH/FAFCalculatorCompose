package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.testcompose.ui.navigation.MainNavHost
import com.example.testcompose.ui.theme.FafCalculatorComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FafCalculatorComposeTheme() {
                MainNavHost()
            }
        }
    }
}