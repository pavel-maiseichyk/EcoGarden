package com.pm.ecogarden.profile_feature.presentation.settings_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pm.ecogarden.auth.auth_one_click.domain.repository.Repository
import com.pm.ecogarden.shared.util.RequestState
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val repository: Repository
) : ViewModel() {

    var state by mutableStateOf(SettingsState())
        private set

    fun onEvent(event: SettingsEvent) {
        when (event) {
            is SettingsEvent.ChangeUserNameButtonClicked -> {
                state = state.copy(
                    isUserNameFieldVisible = !state.isUserNameFieldVisible
                )
            }
            is SettingsEvent.ChangeGardenNameButtonClicked -> {
                state = state.copy(
                    isGardenNameFieldVisible = !state.isGardenNameFieldVisible
                )
            }
            is SettingsEvent.UserNameChanged -> {
                state = state.copy(
                    userName = event.value
                )
            }
            is SettingsEvent.GardenNameChanged -> {
                state = state.copy(
                    gardenName = event.value
                )
            }
            is SettingsEvent.SaveUserNameButtonClicked -> {
                state = state.copy(
                    userName = "",
                    isUserNameFieldVisible = false
                )
            }
            is SettingsEvent.SaveGardenNameButtonClicked -> {
                state = state.copy(
                    gardenName = "",
                    isGardenNameFieldVisible = false
                )
            }
            is SettingsEvent.DeleteUserButtonClicked -> {

            }
        }
    }

    fun updateUserInfo() {
        viewModelScope.launch {
            state = state.copy(apiResponse = RequestState.Loading)
            try {
                if (state.user != null) {
                    val response = repository.getUserInfo()
                    //update messageBarInfo
                }
            } catch (e: Exception) {
                state = state.copy(apiResponse = RequestState.Error(e))
            }
        }
    }
}