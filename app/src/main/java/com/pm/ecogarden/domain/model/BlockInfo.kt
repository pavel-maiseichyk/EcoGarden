package com.pm.ecogarden.domain.model

data class BlockInfo(
    val userId: String,
    val blockId: Int,
    var plantType: PlantType?,
    var growthLevel: GrowthLevelType?,
    val xBlocksFromMain: Int,
    val yBlocksFromMain: Int
)

val emptyBlockInfo = BlockInfo(
    userId = "0",
    blockId = 0,
    plantType = null,
    growthLevel = null,
    xBlocksFromMain = 0,
    yBlocksFromMain = 0
)

val emptyBlocks: List<BlockInfo> = listOf(
    BlockInfo(
        userId = "0",
        blockId = 0,
        plantType = null,
        growthLevel = null,
        xBlocksFromMain = 0,
        yBlocksFromMain = 0
    ),
    BlockInfo(
        userId = "0",
        blockId = 1,
        plantType = null,
        growthLevel = null,
        xBlocksFromMain = 1,
        yBlocksFromMain = 0
    ),
    BlockInfo(
        userId = "0",
        blockId = 2,
        plantType = null,
        growthLevel = null,
        xBlocksFromMain = 1,
        yBlocksFromMain = -1
    ),
//    BlockInfo(
//        userId = "0",
//        blockId = 3,
//        plantType = null,
//        growthLevel = null
//    ),
//    BlockInfo(
//        userId = "0",
//        blockId = 4,
//        plantType = null,
//        growthLevel = null
//    ),
//    BlockInfo(
//        userId = "0",
//        blockId = 5,
//        plantType = null,
//        growthLevel = null
//    ),
//    BlockInfo(
//        userId = "0",
//        blockId = 6,
//        plantType = null,
//        growthLevel = null
//    ),
//    BlockInfo(
//        userId = "0",
//        blockId = 7,
//        plantType = null,
//        growthLevel = null
//    ),
//    BlockInfo(
//        userId = "0",
//        blockId = 8,
//        plantType = null,
//        growthLevel = null
//    )
)