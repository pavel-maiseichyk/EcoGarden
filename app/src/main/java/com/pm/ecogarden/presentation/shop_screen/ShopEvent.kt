package com.pm.ecogarden.garden.presentation.shop_screen

import com.pm.ecogarden.garden.domain.model.GrowthLevelType
import com.pm.ecogarden.garden.domain.model.PlantType

sealed class ShopEvent {
    data class UpdateBlock(
        val blockId: Int,
        val newPlantType: PlantType?,
        var newGrowthLevel: GrowthLevelType?,
    ) : ShopEvent()

    object UpdateRowAmount : ShopEvent()
    object OnCloseButtonClick : ShopEvent()
}