package com.pm.ecogarden.presentation.garden_screen

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pm.ecogarden.domain.model.emptyBlocks
import com.pm.ecogarden.presentation.destinations.ShopScreenDestination
import com.pm.ecogarden.presentation.garden_screen.components.GrassField
import com.pm.ecogarden.presentation.garden_screen.components.ShopButton
import com.pm.ecogarden.presentation.garden_screen.components.detectTransformGestures
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun GardenScreen(
    navigator: DestinationsNavigator,
    vm: GardenViewModel = hiltViewModel()
) {
    val backgroundColor = Color.White
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(backgroundColor)
    }

    var zoom by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    var isTransforming by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxSize()
    ) {
        GrassField(
            blocks = emptyBlocks,
            //vm.blockList,
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTransformGestures(
                        onGestureStart = {
                                isTransforming = true
                        },
                        onGestureEnd = {
                           isTransforming = false
                        },
//                        onGesture = { centroid, pan, gestureZoom, _ ->
//                            val oldScale = zoom
//                            val newScale = zoom * gestureZoom
//                            offset = (offset + centroid / oldScale) -
//                                    (centroid / newScale + pan / oldScale)
//                            zoom = newScale
//                        }
                        onGesture = { centroid: Offset,
                                      pan: Offset,
                                      gestureZoom: Float,
                                      _, _, _ ->
                            val oldScale = zoom
                            val newScale = zoom * gestureZoom
                            offset = (offset + centroid / oldScale) -
                                    (centroid / newScale + pan / oldScale)
                            zoom = newScale
                        },
                    )
//                    forEachGesture {
//                        isTransforming = true
//                    }
                }
                .graphicsLayer {
                    translationX = -offset.x * zoom
                    translationY = -offset.y * zoom
                    scaleX = zoom
                    scaleY = zoom
                    transformOrigin = TransformOrigin(0f, 0f)
                }
        )
        AnimatedVisibility(
            visible = !isTransforming,
            enter = fadeIn() + expandHorizontally(),
            exit = fadeOut() + shrinkHorizontally()
        ) {
            ShopButton(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 80.dp),
                onClick = {
                    navigator.navigate(ShopScreenDestination)
                }
            )
        }
    }
}