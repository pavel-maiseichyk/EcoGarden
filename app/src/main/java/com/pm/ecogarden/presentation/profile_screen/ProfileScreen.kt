package com.pm.ecogarden.presentation.profile_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pm.ecogarden.R
import com.pm.ecogarden.presentation.destinations.FriendsScreenDestination
import com.pm.ecogarden.presentation.destinations.SettingsScreenDestination
import com.pm.ecogarden.presentation.destinations.StatisticsScreenDestination
import com.pm.ecogarden.ui.theme.EndGradientBackground
import com.pm.ecogarden.ui.theme.StartGradientBackground
import com.pm.ecogarden.ui.theme.myFontFamily
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
    vm: ProfileViewModel = hiltViewModel()
) {
    val state = vm.state
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(StartGradientBackground)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        StartGradientBackground,
                        EndGradientBackground
                    )
                )
            )
    ) {
        IconButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(horizontal = 16.dp, vertical = 32.dp),
            onClick = {
                navigator.navigate(SettingsScreenDestination)
            }
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_settings_button
                ), contentDescription = "settings button"
            )
        }
        Column {
            Row(
                Modifier
                    .padding(16.dp)
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier.size(85.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(vm.state.profilePhoto)
                        //  .size(100, 100)
                        .crossfade(500)
                        .error(R.drawable.ic_profile_picture)
                        .placeholder(R.drawable.ic_profile_picture)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentDescription = "Profile Image"
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = state.username,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = myFontFamily,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = state.gardenName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = myFontFamily,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Text(
                text = "Друзья  >>",
                fontSize = 40.sp,
                fontFamily = myFontFamily,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        navigator.navigate(FriendsScreenDestination)
                    }
            )
            Text(
                text = "Статистика  >>",
                fontSize = 40.sp,
                fontFamily = myFontFamily,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        navigator.navigate(StatisticsScreenDestination)
                    }
            )
        }
    }
}