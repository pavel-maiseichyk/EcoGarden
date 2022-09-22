package com.pm.ecogarden.presentation.settings_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pm.ecogarden.presentation.settings_screen.components.DisplayAlertDialog
import com.pm.ecogarden.sort_later.presentation.shared_composables.CloseButton
import com.pm.ecogarden.ui.theme.MildBackground
import com.pm.ecogarden.util.UiEvent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SettingsScreen(
    navigator: DestinationsNavigator,
    vm: SettingsViewModel = hiltViewModel(),
    snackbarHostState: SnackbarHostState
) {
    val state = vm.state
    var openDialog by remember { mutableStateOf(false) }
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current

    SideEffect {
        systemUiController.setStatusBarColor(MildBackground)
    }

    LaunchedEffect(true) {
        vm.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack -> navigator.navigateUp()
                is UiEvent.NavigateTo -> navigator.navigate(event.destination)
                is UiEvent.ShowSnackbar -> snackbarHostState.showSnackbar(
                    event.message.asString(
                        context
                    )
                )
            }
        }
    }

    DisplayAlertDialog(
        openDialog = openDialog,
        onYesClicked = { vm.onEvent(SettingsEvent.LogOutButtonClicked) },
        onDialogClosed = { openDialog = false }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MildBackground),
    ) {
        CloseButton(
            onClick = { navigator.navigateUp() },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    vm.onEvent(SettingsEvent.ChangeUserNameButtonClicked)
                }
            ) {
                Text(text = "Change Username")
            }
            AnimatedVisibility(visible = state.isUserNameFieldVisible) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OutlinedTextField(
                        value = state.username,
                        onValueChange = {
                            vm.onEvent(SettingsEvent.UserNameChanged(it))
                        },
                        modifier = Modifier.width(200.dp)
                    )
                    Button(
                        onClick = {
                            vm.onEvent(SettingsEvent.SaveUserNameButtonClicked)
                        }
                    ) {
                        Text(text = "Update")
                    }
                }
            }
            Button(
                onClick = { vm.onEvent(SettingsEvent.ChangeGardenNameButtonClicked) }
            ) {
                Text(text = "Change Garden Name")
            }
            AnimatedVisibility(visible = state.isGardenNameFieldVisible) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OutlinedTextField(
                        value = state.gardenName,
                        onValueChange = {
                            vm.onEvent(SettingsEvent.GardenNameChanged(it))
                        },
                        modifier = Modifier.width(200.dp)
                    )
                    Button(
                        onClick = {
                            vm.onEvent(SettingsEvent.SaveGardenNameButtonClicked)
                        }
                    ) {
                        Text(text = "Update")
                    }
                }
            }
            Button(
                onClick = { openDialog = true }
            ) {
                Text(text = "Log Out And Save")
            }
            Button(
                onClick = { vm.onEvent(SettingsEvent.DeleteUserButtonClicked) }
            ) {
                Text(text = "Delete User")
            }
        }
    }
}