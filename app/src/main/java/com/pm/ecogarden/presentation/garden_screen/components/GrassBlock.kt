package com.pm.ecogarden.garden.presentation.garden_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.pm.ecogarden.R
import com.pm.ecogarden.garden.domain.model.BlockInfo
import com.pm.ecogarden.garden.domain.model.GrowthLevelType
import com.pm.ecogarden.garden.domain.model.PlantType

@Composable
fun GrassBlock(
    blockInfo: BlockInfo,
    modifier: Modifier = Modifier
) {
    @DrawableRes var chosenImagePath: Int = R.drawable.ic_grass_block
    val isEmpty = blockInfo.isEmpty
    val plantType = blockInfo.plantType
    val growthLevel = blockInfo.growthLevel

    if (!isEmpty) {
        when (plantType) {
            PlantType.OakTree -> {
                chosenImagePath = when (growthLevel) {
                    GrowthLevelType.LevelOne -> {
                        R.drawable.ic_oak_tree_on_block
                    }
                    else -> {
                        R.drawable.ic_oak_tree_on_block
                    }
                }
            }
            PlantType.SakuraTree -> {
                chosenImagePath = when (growthLevel) {
                    GrowthLevelType.LevelOne -> {
                        R.drawable.ic_sakura_tree_on_block
                    }
                    else -> {
                        R.drawable.ic_sakura_tree_on_block
                    }
                }
            }
            PlantType.OrangeBush -> {
                chosenImagePath = when (growthLevel) {
                    GrowthLevelType.LevelOne -> {
                        R.drawable.ic_orange_bush_on_block
                    }
                    else -> {
                        R.drawable.ic_orange_bush_on_block
                    }
                }
            }
        }
    }

    Image(
        painter = painterResource(id = chosenImagePath),
        contentDescription = "grass block"
    )
}