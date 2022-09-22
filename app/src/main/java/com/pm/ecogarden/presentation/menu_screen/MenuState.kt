package com.pm.ecogarden.trash_feature.presentation.menu_screen

import com.pm.ecogarden.trash_feature.presentation.add_screen.TrashType
import com.pm.ecogarden.trash_feature.presentation.menu_screen.components.MenuItem

data class MenuState(
    val trashType: TrashType? = null,
    val startAmount: Int = 0,
    val amountToAdd: Int = 0,
    val trashList: List<MenuItem> = emptyList()
)