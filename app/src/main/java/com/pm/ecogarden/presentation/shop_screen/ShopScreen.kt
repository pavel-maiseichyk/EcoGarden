package com.pm.ecogarden.presentation.shop_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pm.ecogarden.domain.model.GrowthLevelType
import com.pm.ecogarden.domain.model.PlantType
import com.pm.ecogarden.sort_later.presentation.shared_composables.CloseButton
import com.pm.ecogarden.util.UiEvent
import com.pm.ecogarden.ui.theme.MildBackground
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ShopScreen(
    navigator: DestinationsNavigator,
    viewModel: ShopViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(MildBackground)
    }

    LaunchedEffect(true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> {
                    navigator.navigateUp()
                }
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MildBackground)
    ) {
        CloseButton(
            onClick = { navigator.popBackStack() },
            modifier = Modifier.align(Alignment.TopEnd)
        )
        Column(modifier = Modifier.align(Alignment.Center)) {
//            Button(onClick = { viewModel.onEvent(ShopEvent.UpdateRowAmount) }) {
//                Text(text = "Add Row")
//            }
            Button(onClick = {
                viewModel.onEvent(
                    ShopEvent.UpdateBlockWithId(
                        blockId = 0,
                        newPlantType = PlantType.OakTree,
                        newGrowthLevel = GrowthLevelType.LevelOne
                    )
                )
            }) {
                Text(text = "Add Oak Tree")
            }
//            Button(onClick = {
//                viewModel.onEvent(ShopEvent.UpdateRandomBlock)
//            }) {
//                Text(text = "Randomly Add Tree")
//            }
        }
    }
}