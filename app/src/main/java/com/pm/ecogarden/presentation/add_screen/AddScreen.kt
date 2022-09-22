package com.pm.ecogarden.presentation.add_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pm.ecogarden.domain.model.TrashType
import com.pm.ecogarden.presentation.add_screen.components.DraggableTrashItem
import com.pm.ecogarden.presentation.add_screen.components.TrashCan
import com.pm.ecogarden.presentation.destinations.MenuScreenDestination
import com.pm.ecogarden.ui.theme.BasketBackground
import com.pm.ecogarden.ui.theme.EndGradientBackground
import com.pm.ecogarden.ui.theme.LocalSpacing
import com.pm.ecogarden.ui.theme.StartGradientBackground
import com.pm.ecogarden.util.DropTarget
import com.pm.ecogarden.util.LongPressDraggable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AddScreen(
    navigator: DestinationsNavigator
) {
    val spacing = LocalSpacing.current
    val systemUiController = rememberSystemUiController()
    var isOpened by remember { mutableStateOf(false) }

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    val trashCircleHalfSize = screenWidth.times(0.5f)
    val trashCanSize = trashCircleHalfSize.times(1.5f)
    val bubbleSize = trashCircleHalfSize.times(0.67f)

    val paddingCanBubble = bubbleSize.times(0.25f)

    SideEffect {
        systemUiController.setStatusBarColor(StartGradientBackground)
    }

    LongPressDraggable(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            StartGradientBackground,
                            EndGradientBackground
                        )
                    )
                )
        ) {
            DropTarget<String>(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(
                        x = -trashCircleHalfSize,
                        y = 0.dp
                    )
                    .requiredSize(trashCircleHalfSize * 2)
                    .clip(CircleShape)
                    .background(color = BasketBackground)
            ) { isInBound, arg ->
                isOpened = isInBound
                arg?.let {
                    if (isInBound) {
                        navigator.navigate(MenuScreenDestination(arg))
                    }
                }
                TrashCan(
                    modifier = Modifier.align(Alignment.Center),
                    trashCanSize = trashCanSize,
                    isOpened = isOpened
                )
            }

            DraggableTrashItem(
                trashType = TrashType.MetalCan,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(
                        x = paddingCanBubble * 3,
                        y = -(trashCircleHalfSize + paddingCanBubble * 3)
                    )
            )
            DraggableTrashItem(
                trashType = TrashType.Paper,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(
                        x = paddingCanBubble * 9,
                        y = -(trashCircleHalfSize - paddingCanBubble * 2)
                    )
            )
            DraggableTrashItem(
                trashType = TrashType.PlasticBottle,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(
                        x = trashCircleHalfSize + paddingCanBubble,
                        y = 0.dp
                    )
            )
            DraggableTrashItem(
                trashType = TrashType.GlassBottle,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(
                        x = paddingCanBubble * 9,
                        y = trashCircleHalfSize - paddingCanBubble * 2
                    )
            )
            DraggableTrashItem(
                trashType = TrashType.Battery,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(
                        x = paddingCanBubble * 3,
                        y = trashCircleHalfSize + paddingCanBubble * 3
                    )
            )
        }
    }
}