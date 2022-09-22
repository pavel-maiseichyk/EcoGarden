package com.pm.ecogarden.presentation._components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.pm.ecogarden.domain.model.BottomBarDestination
import com.pm.ecogarden.presentation.NavGraphs
import com.pm.ecogarden.presentation.appCurrentDestinationAsState
import com.pm.ecogarden.presentation.destinations.AddScreenDestination
import com.pm.ecogarden.presentation.destinations.Destination
import com.pm.ecogarden.presentation.destinations.GardenScreenDestination
import com.pm.ecogarden.presentation.destinations.ProfileScreenDestination
import com.pm.ecogarden.presentation.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate

@Composable
fun BottomBar(
    navController: NavController,
    animationDuration: Int = 300,
    bottomNavHeight: Dp = 76.dp,
    lineWidth: Dp = 2.dp
) {
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination

    AnimatedVisibility(
        modifier = Modifier.fillMaxWidth(),
        visible = currentDestination == GardenScreenDestination
                || currentDestination == AddScreenDestination
                || currentDestination == ProfileScreenDestination,
        exit = shrinkVertically(
            animationSpec = tween(animationDuration)
        ),
        enter = expandVertically(
            animationSpec = tween(animationDuration)
        )
    ) {
        Row(
            modifier = Modifier
                .height(bottomNavHeight + lineWidth)
                .fillMaxWidth()
                .background(color = Color.White),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NavBarItem(
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate(
                        BottomBarDestination.Garden.direction,
                        fun NavOptionsBuilder.() {
                            launchSingleTop = true
                        })
                },
                imagePath = if (currentDestination is GardenScreenDestination)
                    BottomBarDestination.Garden.activeIcon
                else BottomBarDestination.Garden.inactiveIcon
            )
            NavBarItem(
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate(
                        BottomBarDestination.Add.direction,
                        fun NavOptionsBuilder.() {
                            launchSingleTop = true
                        })
                },
                imagePath = if (currentDestination is AddScreenDestination)
                    BottomBarDestination.Add.activeIcon
                else BottomBarDestination.Add.inactiveIcon
            )
            NavBarItem(
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate(
                        BottomBarDestination.Profile.direction,
                        fun NavOptionsBuilder.() {
                            launchSingleTop = true
                        })
                },
                imagePath = if (currentDestination is ProfileScreenDestination)
                    BottomBarDestination.Profile.activeIcon
                else BottomBarDestination.Profile.inactiveIcon
            )
//        BottomBarDestination.values().forEach { destination ->
////            val icon =
////                if (backStackEntry.destination.route == destination.direction)
////                    destination.activeIcon else destination.inactiveIcon
//            NavBarItem(
//                modifier = Modifier.weight(1f),
//                onClick = onItemClick,
//                imagePath = destination.inactiveIcon
//            )
//        }
        }
    }
}
