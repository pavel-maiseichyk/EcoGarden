package com.pm.ecogarden.trash_feature.presentation.menu_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pm.ecogarden.sort_later.domain.use_case.DefaultUseCases
import com.pm.ecogarden.trash_feature.presentation.add_screen.TrashType
import com.pm.ecogarden.trash_feature.presentation.menu_screen.use_case.MenuItemAction
import com.pm.ecogarden.trash_feature.presentation.menu_screen.use_case.UpdateMenuItemAmount
import com.pm.ecogarden.shared.util.UiEvent
import com.pm.ecogarden.trash_feature.domain.use_case.GetTrashInfo
import com.pm.ecogarden.trash_feature.domain.use_case.TrashUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MenuViewModel(
//    private val updateMenuItemAmount: UpdateMenuItemAmount,
//    private val trashUseCases: TrashUseCases
) : ViewModel() {

    var state by mutableStateOf(MenuState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var getTrashInfoJob: Job? = null

    init {
        getTrashInfo()
    }

    fun onEvent(event: MenuEvent) {
        when (event) {
            is MenuEvent.OnCloseButtonClick -> {
                viewModelScope.launch {
                    _uiEvent.send(UiEvent.NavigateUp)
                }
            }
            is MenuEvent.SaveNewResourceAmount -> {
//                viewModelScope.launch {
//                    when (event.trashType) {
//                        TrashType.MetalCan -> useCases.saveMetal(event.amount)
//                        TrashType.GlassBottle -> useCases.saveGlass(event.amount)
//                        TrashType.Paper -> useCases.savePaper(event.amount)
//                        TrashType.PlasticBottle -> useCases.savePlastic(event.amount)
//                        TrashType.Battery -> useCases.saveBatteries(event.amount)
//                    }
//                }
            }
            is MenuEvent.OnMinusClick -> {
                // TODO: добавить логику
                //   updateMenuItemAmount(event.item, event.newAmount, MenuItemAction.Minus)
            }
            is MenuEvent.OnPlusClick -> {
                //updateMenuItemAmount(event.item, event.newAmount, MenuItemAction.Plus)
            }
        }
    }

    private fun getTrashInfo() {

    }
}