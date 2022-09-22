package com.pm.ecogarden.presentation.garden_screen.components

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pm.ecogarden.R
import com.pm.ecogarden.ui.theme.ShopButtonBackground
import com.pm.ecogarden.ui.theme.ButtonContent

@Composable
fun ShopButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            ShopButtonBackground, ButtonContent
        ),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_shop_button),
            contentDescription = "shop button"
        )
    }
}