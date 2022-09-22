package com.pm.ecogarden.presentation.statistics_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pm.ecogarden.presentation.statistics_screen.components.StatsDescription
import com.pm.ecogarden.presentation.statistics_screen.components.StatsHeadline
import com.pm.ecogarden.sort_later.presentation.shared_composables.CloseButton
import com.pm.ecogarden.ui.theme.LocalSpacing
import com.pm.ecogarden.ui.theme.MildBackground
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun StatisticsScreen(
    navigator: DestinationsNavigator,
    vm: StatsViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val statsMap = vm.statsMap
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(MildBackground)
    }

    Box(
        modifier = Modifier
            .background(color = MildBackground)
            .fillMaxSize()
            .padding(spacing.spaceMedium)
    ) {
        CloseButton(
            onClick = { navigator.popBackStack() },
            modifier = Modifier.align(Alignment.TopEnd)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            statsMap.forEach { (type, list) ->
                StatsHeadline(
                    type = type,
                    amount = list.sumOf { it.amount },
                    modifier = Modifier.padding(spacing.spaceSmall)
                )
                StatsDescription(list = list)
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
            }
        }
    }
}