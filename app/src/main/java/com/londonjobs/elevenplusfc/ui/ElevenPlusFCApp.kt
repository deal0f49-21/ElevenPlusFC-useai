package com.londonjobs.elevenplusfc.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.londonjobs.elevenplusfc.ui.screen.home.HomeScreen
import com.londonjobs.elevenplusfc.ui.screen.study.StudyScreen
import com.londonjobs.elevenplusfc.ui.screen.test.TestScreen
import com.londonjobs.elevenplusfc.ui.screen.progress.ProgressScreen
import com.londonjobs.elevenplusfc.ui.screen.profile.ProfileScreen
import com.londonjobs.elevenplusfc.ui.theme.GradientEnd
import com.londonjobs.elevenplusfc.ui.theme.GradientStart
import com.londonjobs.elevenplusfc.ui.components.BottomNavBar

@Composable
fun ElevenPlusFCApp() {
    val navController: NavHostController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier
                .background(Brush.verticalGradient(listOf(GradientStart, GradientEnd)))
                .fillMaxSize()
        ) {
            composable("home") { HomeScreen() }
            composable("study") { StudyScreen() }
            composable("test") { TestScreen() }
            composable("progress") { ProgressScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}
