package com.pm.ecogarden.profile_feature.presentation.profile_screen

import com.pm.ecogarden.auth.auth_one_click.domain.model.ApiResponse
import com.pm.ecogarden.shared.util.RequestState

data class ProfileState(
    val userName: String = "Пока нет…",
    val gardenName: String = "ага…",
    val profilePhoto: String? = null,
    val apiResponse: RequestState<ApiResponse> = RequestState.Idle
)
