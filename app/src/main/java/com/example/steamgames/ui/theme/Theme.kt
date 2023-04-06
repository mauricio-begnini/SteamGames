package com.example.steamgames.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Blue3,//Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,

    background = Blue2,
    surface = Blue1,
    onSurface = Grey1,
    onPrimary = Grey2,
    onSecondary = Green1
)

private val LightColorPalette = lightColors(
    primary = Blue3,//Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,

    background = Blue2,
    surface = Blue1,
    onSurface = Grey1,
    onPrimary = Grey2,
    onSecondary = Green1

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SteamGamesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}