package com.example.testcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testcompose.Destinations.EXP_ROUTE
import com.example.testcompose.Destinations.MAIN_ROUTE
import com.example.testcompose.Destinations.SETTINGS_ROUTE
import com.example.testcompose.ui.exp.ExpScreen
import com.example.testcompose.ui.main.MainScreen
import com.example.testcompose.ui.settings.SettingsScreen
import com.example.testcompose.ui.test.TestScreen

object Destinations {
    const val MAIN_ROUTE = "main"
    const val EXP_ROUTE = "exp"
    const val SETTINGS_ROUTE = "settings"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
) {

    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected = false,
                    onClick = { navController.navigate(MAIN_ROUTE) },
                    icon = {
                        Image(modifier = Modifier.fillMaxSize().padding(6.dp),
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { navController.navigate(EXP_ROUTE) },
                    icon = {
                        Image(modifier = Modifier.fillMaxSize().padding(6.dp),
                            painter = painterResource(id = R.drawable.emissary),
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { navController.navigate(SETTINGS_ROUTE) },
                    icon = {
                        Image(modifier = Modifier.fillMaxSize().padding(6.dp),
                            painter = painterResource(id = R.drawable.ic_settings),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = MAIN_ROUTE,
        ) {
            composable(MAIN_ROUTE) {
                MainScreen(
                    modifier = Modifier.padding(paddingValues),
                    mainViewModel = hiltViewModel(),
                    navController = navController
                )
            }

            composable(EXP_ROUTE) {
                ExpScreen()
            }

            composable(SETTINGS_ROUTE) {
                SettingsScreen(settingsViewModel = hiltViewModel())
            }
        }
    }

}
