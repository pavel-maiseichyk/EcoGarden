package com.pm.ecogarden.presentation.menu_screen

import com.pm.ecogarden.presentation.menu_screen.components.MenuItem

sealed class MenuEvent {
    object OnCloseButtonClick : MenuEvent()
    object OnSaveClick : MenuEvent()
    data class OnPlusClick(val item: MenuItem) : MenuEvent()
    data class OnMinusClick(val item: MenuItem) : MenuEvent()
}