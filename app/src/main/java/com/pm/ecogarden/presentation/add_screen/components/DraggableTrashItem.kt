package com.pm.ecogarden.presentation.add_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pm.ecogarden.domain.model.TrashType
import com.pm.ecogarden.util.DragTarget

@Composable
fun DraggableTrashItem(
    modifier: Modifier = Modifier,
    trashType: TrashType
) {

    Box(
        modifier = modifier
            .requiredSize(126.dp)
            .clip(CircleShape)
            .background(
                color = trashType.arcColor
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .requiredSize(92.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            trashType.startGradientColor,
                            trashType.endGradientColor
                        )
                    ),
                ),
            contentAlignment = Alignment.Center
        ) {
            DragTarget(modifier = Modifier, dataToDrop = trashType.arg) {
                Image(
                    modifier = Modifier
                        .size(63.dp, 76.dp)
                        .padding(4.dp),
                    painter = painterResource(id = trashType.image),
                    contentDescription = "image"
                )
            }
        }
    }
}
