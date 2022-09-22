package com.pm.ecogarden.presentation.menu_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pm.ecogarden.domain.model.TrashType
import com.pm.ecogarden.presentation.menu_screen.components.*
import com.pm.ecogarden.sort_later.presentation.shared_composables.CloseButton
import com.pm.ecogarden.ui.theme.LocalSpacing
import com.pm.ecogarden.ui.theme.MildBackground
import com.pm.ecogarden.util.MenuScreenNavArgs
import com.pm.ecogarden.util.UiEvent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination(navArgsDelegate = MenuScreenNavArgs::class)
@Composable
fun MenuScreen(
    navigator: DestinationsNavigator,
    vm: MenuViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val state = vm.state
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(MildBackground)
    }

    LaunchedEffect(true) {
        vm.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> {
                    navigator.popBackStack()
                }
                else -> {}
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MildBackground)
    ) {
        CloseButton(
            onClick = { navigator.navigateUp() },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(spacing.spaceMedium)
        )
        LazyColumn(modifier = Modifier.padding(top = 75.dp, bottom = 125.dp)) {
            items(state.trashList) { trash ->
                MenuTrashItem(
                    menuTrash = trash,
                    onPlusClick = {
                        vm.onEvent(MenuEvent.OnPlusClick(trash))
                    },
                    onMinusClick = {
                        vm.onEvent(MenuEvent.OnMinusClick(trash))
                    }
                )
            }
        }
        state.image?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = "image",
                alignment = Alignment.BottomStart,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row {
                Text(
                    text = state.startPoints,
                    fontSize = 24.sp,
                )
                Text(
                    text = " + ${state.pointsToAdd}",
                    fontSize = 24.sp,
                    color = Color.Red
                )
            }
            SaveButton(
                onClick = {
                    vm.onEvent(MenuEvent.OnSaveClick)
                }
            )
        }
    }
}
