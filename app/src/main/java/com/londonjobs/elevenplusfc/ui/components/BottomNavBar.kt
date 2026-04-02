package com.londonjobs.elevenplusfc.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        NavItem("Home", "home", Icons.Default.Home),
        NavItem("Study", "study", Icons.Default.School),
        NavItem("Test", "test", Icons.Default.Edit),
        NavItem("Progress", "progress", Icons.Default.Assessment),
        NavItem("Profile", "profile", Icons.Default.Person)
    )
    NavigationBar(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = { Icon(item.icon, contentDescription = item.label, tint = Color.White) },
                label = { Text(item.label) }
            )
        }
    }
}

data class NavItem(val label: String, val route: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
