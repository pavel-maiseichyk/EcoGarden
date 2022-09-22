package com.pm.ecogarden.presentation.auth_screen

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pm.ecogarden.R
import com.pm.ecogarden.domain.model.ApiRequest
import com.pm.ecogarden.presentation.auth_screen.components.*
import com.pm.ecogarden.presentation.destinations.ProfileScreenDestination
import com.pm.ecogarden.ui.theme.LocalSpacing
import com.pm.ecogarden.util.RequestState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun AuthOneClickScreen(
    navigator: DestinationsNavigator,
    viewModel: AuthOneClickViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val statusBarColor = Color.White
    val systemUiController = rememberSystemUiController()
    val activity = LocalContext.current as Activity
    val state = viewModel.state

    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor)
    }
    
    //rewrite completely, get rid of launchedEffect
    LaunchedEffect(key1 = state.apiResponse) {
        when (state.apiResponse) {
            is RequestState.Success -> {
                val response = state.apiResponse.data.success
                if (response) {
                    Log.d("AuthScreen", "Success")
                } else {
                    Log.d("AuthScreen", "Failure")
                    viewModel.endSigningIn()
                }
            }
            else -> Unit
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomCircle(
            modifier = Modifier
                .align(Alignment.TopStart)
                .absoluteOffset(
                    x = (-165).dp / 5 * 2,
                )
                .padding(top = spacing.spaceExtraLarge)
        )
        CustomCircle(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .absoluteOffset(
                    x = 165.dp / 2,
                )
                .padding(bottom = spacing.spaceExtraLarge)
        )
        MessageBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .align(Alignment.TopCenter),
            state = state.messageBarState
        )
        Column(
            modifier = Modifier
                .padding(spacing.spaceLarge)
                .align(Alignment.Center)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            AuthBox(
                onAuthButtonClicked = {
                    viewModel.startSigningIn()
                },
                loadingState = state.isSigningIn,
                onSignButtonClicked = {
                    //     navigator.navigate(GardenScreenDestination)
                },
                login = "",
                password = ""
            )
        }

        StartActivityForResult(
            key = state.isSigningIn,
            onResultReceived = { tokenId ->
                Log.d("AuthScreen", tokenId)
                viewModel.verifyTokenOnBackend(
                    request = ApiRequest(
                        tokenId = tokenId
                    )
                )
            },
            onDialogDismissed = {
                viewModel.endSigningIn()
            }
        ) { activityLauncher ->
            if (state.isSigningIn) {
                signIn(
                    activity = activity,
                    launchActivityResult = { intentSenderRequest ->
                        activityLauncher.launch(intentSenderRequest)
                    },
                    accountNotFound = {
                        viewModel.endSigningIn()
                        viewModel.updateMessageBarState()
                    }
                )
            }
        }
    }
}