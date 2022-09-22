package com.pm.ecogarden.sort_later.presentation.shared_composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pm.ecogarden.R

@Composable
fun CloseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Icon(
        painterResource(id = R.drawable.ic_exit_button),
        contentDescription = "go back button",
        tint = Color.Red,
        modifier = modifier
            .size(35.dp)
            .clickable {
            onClick()
        }
    )
}