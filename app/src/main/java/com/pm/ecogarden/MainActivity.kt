package com.pm.ecogarden

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.pm.ecogarden.domain.model.ApiRequest
import com.pm.ecogarden.domain.model.ApiResponse
import com.pm.ecogarden.presentation.NavGraphs
import com.pm.ecogarden.presentation._components.BottomBar
import com.pm.ecogarden.presentation.auth_screen.components.StartActivityForResult
import com.pm.ecogarden.presentation.auth_screen.components.signIn
import com.pm.ecogarden.presentation.destinations.SettingsScreenDestination
import com.pm.ecogarden.presentation.settings_screen.SettingsScreen
import com.pm.ecogarden.ui.theme.EcoGardenTheme
import com.pm.ecogarden.util.RequestState
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.utils.startDestination
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.HttpException

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val vm: MainViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            vm.shouldShowSplashScreen
        }
        setContent {
            val navController = rememberNavController()
            val snackbarHostState = remember { SnackbarHostState() }
            EcoGardenTheme {
                Scaffold(
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    bottomBar = { BottomBar(navController) },
                    content = {
                        vm.startDestination?.startDestination?.let { startRoute ->
                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                                startRoute = startRoute,
                                navController = navController
                            ) {
                                composable(SettingsScreenDestination) {
                                    SettingsScreen(
                                        snackbarHostState = snackbarHostState,
                                        navigator = destinationsNavigator
                                    )
                                }
                            }
                        }
                    }
                )
            }
            val requestState = vm.requestState
            StartActivityForResult(
                key = requestState,
                onResultReceived = { tokenId ->
                    vm.verifyTokenOnBackend(
                        request = ApiRequest(tokenId = tokenId)
                    )
                },
                onDialogDismissed = { }
            ) { activityLauncher ->
                if (requestState is RequestState.Success<*>) {
                    val response = (requestState as RequestState.Success<ApiResponse>).data
                    if (response.error is HttpException && response.error.code() == 401) {
                        signIn(
                            activity = this,
                            accountNotFound = {
//                                vm.saveSignedInState(signedIn = false)
//                                navigateToLoginScreen(navController = navController)
                            },
                            launchActivityResult = {
                                activityLauncher.launch(it)
                            }
                        )
                    }
                } else if (requestState is RequestState.Error) {
//                    profileViewModel.saveSignedInState(signedIn = false)
//                    navigateToLoginScreen(navController = navController)
                }
            }
        }
    }
}
