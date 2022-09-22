package com.pm.ecogarden.presentation._components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pm.ecogarden.ui.theme.EcoGreen

@Composable
fun NavBarItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes imagePath: Int,
) {
    Box(
        modifier
            .background(Color.White)
            .height(80.dp)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawLine(
                color = EcoGreen,
                start = Offset.Zero,
                end = Offset(size.width, 0f),
                strokeWidth = 2f
            )
        }
        Icon(
            painter = painterResource(id = imagePath),
            contentDescription = "image",
            tint = EcoGreen,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}