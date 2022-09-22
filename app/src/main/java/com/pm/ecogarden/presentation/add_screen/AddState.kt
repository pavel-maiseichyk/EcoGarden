package com.pm.ecogarden.trash_feature.presentation.add_screen

data class AddState(
    val isTrashBinOpened: Boolean = false,
    val isTrashItemHeld: Boolean = false,
    val heldTrashType: TrashType? = null
)
