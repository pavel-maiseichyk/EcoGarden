package com.pm.ecogarden.auth.auth_one_click.presentation

import com.pm.ecogarden.auth.auth_one_click.domain.model.ApiResponse
import com.pm.ecogarden.auth.auth_one_click.domain.model.MessageBarState
import com.pm.ecogarden.shared.util.RequestState

data class AuthState(
    val signedInState: Boolean = false,
    val messageBarState: MessageBarState = MessageBarState(),
    val apiResponse: RequestState<ApiResponse> = RequestState.Idle
)
