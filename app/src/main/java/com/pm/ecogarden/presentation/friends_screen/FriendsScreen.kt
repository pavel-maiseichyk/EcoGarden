package com.pm.ecogarden.presentation.friends_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pm.ecogarden.sort_later.presentation.shared_composables.CloseButton
import com.pm.ecogarden.ui.theme.MildBackground
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun FriendsScreen(
    navigator: DestinationsNavigator
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(MildBackground)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MildBackground)
    ) {
        CloseButton(
            onClick = {
                navigator.popBackStack()
            },
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}