package com.example.project.ui

import android.app.Activity
import android.content.res.Configuration
import android.view.View
import android.view.Window
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat

object CSCE3220Project3Theme {

    @Composable
    fun Theme(
        darkTheme: Boolean,
        dynamicColor: Boolean,
        content: @Composable () -> Unit
    ) {
        val colorScheme = getColorScheme(darkTheme, dynamicColor)

        ApplyStatusBarColor(colorScheme, darkTheme)

        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }

    @Composable
    private fun getColorScheme(darkTheme: Boolean, dynamicColor: Boolean): ColorScheme {
        return if (dynamicColor) {
            if (darkTheme) {
                dynamicDarkColorScheme(LocalContext.current())
            } else {
                dynamicLightColorScheme(LocalContext.current())
            }
        } else {
            if (darkTheme) {
                darkColorScheme()
            } else {
                lightColorScheme()
            }
        }
    }

    @Composable
    private fun ApplyStatusBarColor(colorScheme: ColorScheme, darkTheme: Boolean) {
        val context = LocalContext.current()
        val view = View(context)

        if (!view.isInEditMode) {
            SideEffect {
                val activity = context as? Activity
                activity?.let {
                    val window: Window = it.window
                    window.statusBarColor = colorScheme.primary.toArgb()
                    WindowCompat.getInsetsController(window, view)?.isAppearanceLightStatusBars = darkTheme
                }
            }
        }
    }
}
