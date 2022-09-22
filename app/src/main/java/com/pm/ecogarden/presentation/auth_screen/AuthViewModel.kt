package com.pm.ecogarden.presentation.auth_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pm.ecogarden.domain.model.ApiRequest
import com.pm.ecogarden.domain.model.MessageBarState
import com.pm.ecogarden.domain.repository.UserRepository
import com.pm.ecogarden.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthOneClickViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var state by mutableStateOf(AuthState())
        private set

//    init {
//        viewModelScope.launch {
//            repository.readSignedInState().collect { collectedState ->
//                state = state.copy(isSigningIn = collectedState)
//            }
//        }
//    }

    fun startSigningIn() {
        state = state.copy(isSigningIn = true)
    }

    fun endSigningIn() {
        state = state.copy(isSigningIn = false)
    }

    private fun saveSignedInState(signedIn: Boolean) {
        viewModelScope.launch {
            repository.saveSignedInState(signedIn)
        }
    }

    fun updateMessageBarState() {
        state = state.copy(
            messageBarState = MessageBarState(
                error = GoogleAccountNotFoundException()
            )
        )
    }

    fun verifyTokenOnBackend(request: ApiRequest) {
        state = state.copy(apiResponse = RequestState.Loading)
        try {
            viewModelScope.launch {
                val response = repository.verifyTokenOnBackend(request)
                state = state.copy(
                    apiResponse = RequestState.Success(response),
                    messageBarState = MessageBarState(
                        message = response.message,
                        error = response.error
                    )
                )
                saveSignedInState(true)
            }
        } catch (e: Exception) {
            state = state.copy(
                apiResponse = RequestState.Error(e),
                messageBarState = MessageBarState(error = e)
            )
            saveSignedInState(false)
        }
    }
}

class GoogleAccountNotFoundException(
    override val message: String? = "Google Account Not Found"
) : Exception()