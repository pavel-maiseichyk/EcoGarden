package com.pm.ecogarden.presentation.menu_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pm.ecogarden.ui.theme.ButtonContent
import com.pm.ecogarden.ui.theme.MildBackground
import com.pm.ecogarden.ui.theme.myFontFamily

@Composable
fun SaveButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "Добавить",
    backgroundColor: Color = MildBackground,
    borderColor: Color = ButtonContent
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.border(
            width = 2.dp,
            color = borderColor,
            shape = RoundedCornerShape(10.dp)
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = backgroundColor,
            contentColor = Color.Black
        )
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            fontFamily = myFontFamily
        )
    }
}