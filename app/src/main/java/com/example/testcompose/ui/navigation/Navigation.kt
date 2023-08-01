package com.example.testcompose.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testcompose.ui.screens.exp.ExpScreen
import com.example.testcompose.ui.screens.main.MainScreen
import com.example.testcompose.ui.navigation.Route.EXP_ROUTE
import com.example.testcompose.ui.navigation.Route.MAIN_ROUTE
import com.example.testcompose.ui.navigation.Route.SETTINGS_ROUTE
import com.example.testcompose.ui.screens.settings.SettingsScreen
import kotlinx.parcelize.Parcelize

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
) {

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route

                TOP_LEVEL_DESTINATIONS.forEach {
                    BottomNavigationItem(
                        selected = currentRoute == it.route,
                        onClick = {
                            navController.navigate(it.route) {
//                                popUpTo(navController.graph.findStartDestination().id) {
//                                    saveState = true
//                                }
                                popUpTo(0) { inclusive = true }
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = it.selectedIcon,
                                contentDescription = stringResource(id = it.iconTextId)
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = it.iconTextId),
                                fontSize = 9.sp,
                            )
                        }, selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black
                    )
                }
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
                    mainViewModel = hiltViewModel()
                )
            }

            composable(EXP_ROUTE) {
                ExpScreen(
                    navController = navController,
                    expViewModel = hiltViewModel()
                )
            }

            composable(SETTINGS_ROUTE) {
                SettingsScreen(settingsViewModel = hiltViewModel())
            }
        }
    }
}