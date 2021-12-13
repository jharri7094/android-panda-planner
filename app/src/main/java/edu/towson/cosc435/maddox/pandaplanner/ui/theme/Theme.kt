package edu.towson.cosc435.maddox.pandaplanner.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = textGreen,
    primaryVariant = textBrown,
    secondary = BambooBrown,
    onSecondary = iconColor,
    background = surface,
    surface = boxGreen,
    onSurface = onSurface
)

private val LightColorPalette = lightColors(
    primary = textGreen,
    primaryVariant = textBrown,
    secondary = BambooBrown,
    onSecondary = iconColor,
    background = boxGreen,
    surface = surface,
    onSurface = onSurface

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
fun PandaPlannerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
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