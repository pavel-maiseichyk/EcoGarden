package com.pm.ecogarden.util

import com.pm.ecogarden.data.local.blocks.BlockEntity
import com.pm.ecogarden.domain.model.BlockInfo
import com.pm.ecogarden.domain.model.GrowthLevelType
import com.pm.ecogarden.domain.model.PlantType

fun BlockInfo.toBlockEntity(): BlockEntity {
    return BlockEntity(
        userId = userId,
        blockId = blockId,
        plantType = plantType?.name,
        growthLevel = growthLevel?.type,
        xBlocksFromMain = xBlocksFromMain,
        yBlocksFromMain = yBlocksFromMain
    )
}

fun BlockEntity.toBlockInfo(): BlockInfo {
    return BlockInfo(
        userId = userId,
        blockId = blockId,
        plantType = plantType?.let { PlantType.fromString(it) },
        growthLevel = growthLevel?.let { GrowthLevelType.fromString(it) },
        xBlocksFromMain = xBlocksFromMain,
        yBlocksFromMain = yBlocksFromMain
    )
}