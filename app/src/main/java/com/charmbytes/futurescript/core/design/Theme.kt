package com.charmbytes.futurescript.core.design
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
private val LightScheme = lightColorScheme(
    primary = PinkPrimary, onPrimary = White,
    secondary = PinkDark,  onSecondary = White,
    background = BlushBg,  onBackground = TextOnPink,
    surface = BlushBg,     onSurface = TextOnPink
)
@Composable
fun FutureScriptTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = LightScheme, typography = Typography(), content = content)
}
