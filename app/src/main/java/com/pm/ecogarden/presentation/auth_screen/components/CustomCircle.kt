package com.pm.ecogarden.auth.auth_one_click.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomCircle(
    modifier: Modifier = Modifier,
    size: Dp = 165.dp,
    gradientColors: List<Color> = listOf(Color(0xFFD3FFCA), Color(0xFFFDFFC8))
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(
                brush = Brush.verticalGradient(gradientColors)
            )
    )
}
