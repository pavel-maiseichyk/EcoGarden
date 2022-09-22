package com.pm.ecogarden.presentation.menu_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pm.ecogarden.ui.theme.MenuBackground
import com.pm.ecogarden.ui.theme.MenuBackgroundBorder
import com.pm.ecogarden.R
import com.pm.ecogarden.ui.theme.LocalSpacing

@ExperimentalMaterial3Api
@Composable
fun MenuTrashItem(
    menuTrash: MenuItem,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit
) {
    val spacing = LocalSpacing.current
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = spacing.spaceSmall,
                vertical = spacing.spaceExtraSmall
            ),
        colors = CardDefaults.cardColors(
            containerColor = MenuBackground
        ),
        border = BorderStroke(width = 1.dp, color = MenuBackgroundBorder)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.spaceExtraSmall)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = menuTrash.imagePath),
                    contentDescription = "image",
                    modifier = Modifier
                        .size(55.dp)
                        .padding(horizontal = 4.dp)
                )
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                Text(text = menuTrash.name.split(" -")[0], fontSize = 16.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterEnd),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = limitDigits(menuTrash.count),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .size(70.dp, 20.dp)
                        .border(
                            color = Color.Black,
                            width = 1.dp,
                            shape = RoundedCornerShape(10.dp)
                        )
                )
                Spacer(modifier = Modifier.width(spacing.spaceExtraSmall))
                Column(
                    modifier = Modifier.fillMaxHeight(),
                ) {
                    IconButton(
                        onClick = onPlusClick
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add_button),
                            contentDescription = "add button",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    IconButton(
                        onClick = {
                            if (menuTrash.count > 0) onMinusClick()
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_subtract_button),
                            contentDescription = "subtract button",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

//turn into usecase
fun limitDigits(amount: Int): String {
    if (amount < 0) return "0"
    if (amount in 1000..999999) return "${amount / 1000}k"
    if (amount >= 1000000) return "1m"
    return amount.toString()
}