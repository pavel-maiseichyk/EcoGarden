package com.pm.ecogarden.presentation.menu_screen.components

import androidx.annotation.DrawableRes
import com.pm.ecogarden.domain.model.TrashType

data class MenuItem(
    @DrawableRes val imagePath: Int,
    val name: String,
    val count: Int = 0,
    val value: Int = 0,
    val trashType: TrashType
)
