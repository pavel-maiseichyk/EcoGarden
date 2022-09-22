package com.pm.ecogarden.profile_feature.presentation.settings_screen

import com.pm.ecogarden.auth.auth_one_click.domain.model.ApiResponse
import com.pm.ecogarden.auth.auth_one_click.domain.model.MessageBarState
import com.pm.ecogarden.shared.util.RequestState

data class SettingsState(
    val userName: String = "",
    val gardenName: String = "",
    val apiResponse: RequestState<ApiResponse> = RequestState.Idle,
    val isUserNameFieldVisible: Boolean = false,
    val isGardenNameFieldVisible: Boolean = false,
    val messageBarState: MessageBarState = MessageBarState()
)
