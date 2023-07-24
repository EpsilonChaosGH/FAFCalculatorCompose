package com.example.testcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testcompose.Destinations.EXP_ROUTE
import com.example.testcompose.Destinations.MAIN_ROUTE
import com.example.testcompose.ui.exp.ExpScreen
import com.example.testcompose.ui.main.MainScreen

object Destinations {
    const val MAIN_ROUTE = "main"
    const val EXP_ROUTE = "exp"
}

@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = MAIN_ROUTE,
    ) {
        composable(MAIN_ROUTE) {
            MainScreen(
                onNavigateToExp = {
                    navController.navigate("exp")
                }
            )
        }

        composable(EXP_ROUTE) {
            ExpScreen()
        }
    }
}
