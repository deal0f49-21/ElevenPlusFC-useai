package com.londonjobs.elevenplusfc.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun ElevenPlusFCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) darkColorScheme(
        primary = DeepPurple,
        secondary = DeepBlue,
        background = Color(0xFF121212),
        surface = Color(0xFF1E1E1E),
    ) else lightColorScheme(
        primary = DeepPurple,
        secondary = DeepBlue,
        background = Color(0xFFF5F5FF),
        surface = Color(0xFFFFFFFF),
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
