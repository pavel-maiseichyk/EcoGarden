package com.pm.ecogarden.domain.model

import androidx.annotation.DrawableRes
import com.pm.ecogarden.R
import com.pm.ecogarden.presentation.destinations.AddScreenDestination
import com.pm.ecogarden.presentation.destinations.GardenScreenDestination
import com.pm.ecogarden.presentation.destinations.ProfileScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

sealed class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    @DrawableRes val inactiveIcon: Int,
    @DrawableRes val activeIcon: Int
) {
    object Garden : BottomBarDestination(
        direction = GardenScreenDestination,
        inactiveIcon = R.drawable.ic_tree_button_inactive,
        activeIcon = R.drawable.ic_tree_button_active
    )

    object Add : BottomBarDestination(
        direction = AddScreenDestination,
        inactiveIcon = R.drawable.ic_plus_button_inactive,
        activeIcon = R.drawable.ic_plus_button_active
    )

    object Profile : BottomBarDestination(
        direction = ProfileScreenDestination,
        inactiveIcon = R.drawable.ic_profile_button_inactive,
        activeIcon = R.drawable.ic_profile_button_active
    )
}

//data class BottomBarDestinationData(
//    val direction: DirectionDestination,
//    @DrawableRes val inactiveIcon: Int,
//    @DrawableRes val activeIcon: Int
//) {
//    companion object {
//        val list = listOf(
//            BottomBarDestinationData(
//                direction = GardenScreenDestination,
//                inactiveIcon = R.drawable.ic_tree_button_inactive,
//                activeIcon = R.drawable.ic_tree_button_active
//            ),
//            BottomBarDestinationData(
//                direction = AddScreenDestination,
//                inactiveIcon = R.drawable.ic_plus_button_inactive,
//                activeIcon = R.drawable.ic_plus_button_active
//            ),
//            BottomBarDestinationData(
//                direction = ProfileScreenDestination,
//                inactiveIcon = R.drawable.ic_profile_button_inactive,
//                activeIcon = R.drawable.ic_profile_button_active
//            )
//        )
//    }
//}

