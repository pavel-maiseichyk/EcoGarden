package com.pm.ecogarden.garden.presentation.garden_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pm.ecogarden.garden.domain.use_case.BlockUseCases
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class GardenViewModel(
    private val useCases: BlockUseCases
) : ViewModel() {

    var state by mutableStateOf(GardenState())
        private set

    private var getFieldInfoJob: Job? = null

    init {
        refreshField()
    }

    private fun refreshField() {
        getFieldInfoJob?.cancel()
        getFieldInfoJob = useCases.getBlocksInfo()
            .onEach { newBlocks ->
                state = state.copy(
                    blocks = newBlocks
                )
            }
            .launchIn(viewModelScope)
    }
}