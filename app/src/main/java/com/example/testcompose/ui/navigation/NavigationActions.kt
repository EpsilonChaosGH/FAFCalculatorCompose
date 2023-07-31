package com.example.testcompose.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.testcompose.R

object Route {
    const val MAIN_ROUTE = "Main"
    const val EXP_ROUTE = "Exp"
    const val SETTINGS_ROUTE = "Settings"
}

data class TopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = Route.MAIN_ROUTE,
        selectedIcon = Icons.Default.List,
        unselectedIcon = Icons.Default.List,
        iconTextId = R.string.main
    ),
    TopLevelDestination(
        route = Route.EXP_ROUTE,
        selectedIcon = Icons.Default.Check,
        unselectedIcon = Icons.Default.Check,
        iconTextId = R.string.exp
    ),
    TopLevelDestination(
        route = Route.SETTINGS_ROUTE,
        selectedIcon = Icons.Outlined.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        iconTextId = R.string.settings
    )
)