package com.pm.ecogarden.profile_feature.presentation.profile_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pm.ecogarden.auth.auth_one_click.domain.repository.Repository
import com.pm.ecogarden.shared.util.RequestState
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: Repository
) : ViewModel() {

    var state by mutableStateOf(ProfileState())
        private set

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        viewModelScope.launch {
            state = state.copy(apiResponse = RequestState.Loading)
            //update messageBarState
            try {
                val response = repository.getUserInfo()
                state = state.copy(apiResponse = RequestState.Success(response))
                if (response.user != null) {
                    state = state.copy(
                        userName = response.user.name.split(" ").first(),
                        gardenName = response.user.name.split(" ").last()
                    )
                }
            } catch (e: Exception) {
                state = state.copy(apiResponse = RequestState.Error(e))
                //update messageBarState
            }
        }
    }
}