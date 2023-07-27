package com.example.testcompose

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testcompose.Destinations.EXP_ROUTE
import com.example.testcompose.Destinations.MAIN_ROUTE
import com.example.testcompose.ui.exp.ExpScreen
import com.example.testcompose.ui.main.MainScreen
import com.example.testcompose.ui.test.TestScreen

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
//            TestScreen()
            MainScreen(
                mainViewModel = hiltViewModel(),
                navController = navController
            )
        }

        composable(EXP_ROUTE) {
            ExpScreen()
        }
    }
}
