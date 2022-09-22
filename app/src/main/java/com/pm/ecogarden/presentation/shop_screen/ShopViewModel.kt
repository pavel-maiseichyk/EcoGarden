package com.pm.ecogarden.garden.presentation.shop_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pm.ecogarden.garden.domain.use_case.BlockUseCases
import com.pm.ecogarden.shared.util.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ShopViewModel(
    private val useCases: BlockUseCases
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: ShopEvent) {
        when (event) {
            is ShopEvent.UpdateRowAmount -> {
//                viewModelScope.launch {
//                    useCases.updateRowAmount()
//                    _uiEvent.send(UiEvent.NavigateUp)
//                }
            }
            is ShopEvent.UpdateBlock -> {
                viewModelScope.launch {
                    val blockInfo = useCases.getBlockInfoById(event.blockId)
                    val newBlockInfo = blockInfo.copy(
                        isEmpty = (blockInfo.plantType == null) && (event.newPlantType == null),
                        plantType = event.newPlantType,
                        growthLevel = event.newGrowthLevel
                    )
                    useCases.updateBlockInfo(newBlockInfo)
                    _uiEvent.send(UiEvent.NavigateUp)
                }
            }
            is ShopEvent.OnCloseButtonClick -> {
                viewModelScope.launch {
                    _uiEvent.send(UiEvent.NavigateUp)
                }
            }
        }
    }
}