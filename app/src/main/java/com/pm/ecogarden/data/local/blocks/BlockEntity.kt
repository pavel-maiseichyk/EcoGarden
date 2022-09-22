package com.pm.ecogarden.data.local.blocks

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BlockEntity(
    val userId: String,
    @PrimaryKey val blockId: Int,
    var plantType: String?,
    var growthLevel: String?,
    val xBlocksFromMain: Int,
    val yBlocksFromMain: Int
)
