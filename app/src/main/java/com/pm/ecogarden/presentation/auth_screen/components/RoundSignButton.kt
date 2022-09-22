package com.pm.ecogarden.auth.auth_password.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pm.ecogarden.ui.theme.LoadingBlue

@Composable
fun RoundSignButton(
    modifier: Modifier = Modifier,
    loadingState: Boolean = false,
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .clickable(enabled = !loadingState) {
                onClick()
            }
            .background(Color.White)
    ) {
        if (!loadingState) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        if (loadingState) {
            CircularProgressIndicator(
                modifier = Modifier.padding(2.dp),
                strokeWidth = 2.dp,
                color = LoadingBlue
            )
        }
    }
}