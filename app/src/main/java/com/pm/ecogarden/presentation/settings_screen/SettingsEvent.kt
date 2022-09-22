package com.pm.ecogarden.profile_feature.presentation.settings_screen

sealed class SettingsEvent {
    object ChangeUserNameButtonClicked : SettingsEvent()
    object ChangeGardenNameButtonClicked : SettingsEvent()
    data class UserNameChanged(val value: String) : SettingsEvent()
    data class GardenNameChanged(val value: String) : SettingsEvent()
    object SaveUserNameButtonClicked : SettingsEvent()
    object SaveGardenNameButtonClicked : SettingsEvent()
    object DeleteUserButtonClicked : SettingsEvent()
}
