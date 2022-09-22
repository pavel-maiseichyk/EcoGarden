package com.pm.ecogarden.presentation.garden_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pm.ecogarden.domain.model.BlockInfo
import com.pm.ecogarden.domain.model.emptyBlocks

@Preview
@Composable
fun GrassField(
    modifier: Modifier = Modifier,
    blocks: List<BlockInfo> = emptyBlocks,
    verticalSpace: Dp = (-74).dp,
    horizontalSpace: Dp = 100.dp
) {
    var centerBlockCoordinates: Offset by remember {
        mutableStateOf(Offset.Zero)
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (blocks.isNotEmpty()) {
            GrassBlock(
                blockInfo = blocks[0],
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    centerBlockCoordinates = coordinates.positionInRoot()
                }
            )
            val otherBlocks = blocks.subList(1, blocks.size)
            otherBlocks.forEach { blockInfo ->
                val x =
                    centerBlockCoordinates.x.dp + (blockInfo.xBlocksFromMain * horizontalSpace.value).dp
                val y =
                    centerBlockCoordinates.y.dp + (blockInfo.yBlocksFromMain * verticalSpace.value).dp
                GrassBlock(
                    blockInfo = blockInfo,
                    modifier = Modifier.absoluteOffset(x = x, y = y)
//                        .layout { measurable, constraints ->
//                            val placeable = measurable.measure(constraints)
//                            layout(placeable.width, placeable.height) {
//                                placeable.placeRelative(
//                                    x = centerBlockCoordinates.x.toInt() +
//                                            blockInfo.xBlocksFromMain * horizontalSpace.value.toInt(),
//                                    y = centerBlockCoordinates.y.toInt() +
//                                            blockInfo.yBlocksFromMain * verticalSpace.value.toInt()
//                                )
//                            }
//                        }
//                        .absoluteOffset {
//                        IntOffset(
//                            (blockInfo.xBlocksFromMain * horizontalSpace.roundToPx() * this.density).toInt(),
//                            (blockInfo.yBlocksFromMain * verticalSpace.roundToPx()* this.density).toInt()
//                        )
//                    }
                )
            }
        }
//            if (blocks.size == 9)
//                TestField(blocks = blocks)
//        }

    }
}

@Composable
fun TestField(
    blocks: List<BlockInfo>,
    verticalSpace: Dp = 74.dp,
    horizontalSpace: Dp = 100.dp
) {
    Column {
        GrassBlock(blockInfo = blocks[0])
//        GrassBlock(blockInfo = blocks[1],
//            modifier = Modifier.padding(
//                end = horizontalSpace,
//                top = verticalSpace
//            )
//        )
//        GrassBlock(
//            blockInfo = blocks[2],
//            modifier = Modifier.padding(
//                end = horizontalSpace * 2,
//                top = verticalSpace
//            ))
//FieldLengthThree(blocks = blocks)
        //add constraint layout here
    }
}

@Composable
fun FieldLengthThree(
    modifier: Modifier = Modifier,
    blocks: List<BlockInfo>,
    verticalSpace: Dp = (-74).dp,
    horizontalSpace: Dp = 100.dp,
) {


//    Layout(
//        modifier = modifier,
//        content = {
//            blocks.forEach { blockInfo ->
//                GrassBlock(blockInfo = blockInfo)
//            }
//        }
//    ) { measurables, constraints ->
//        val placeables = measurables.map { measurable ->
//            measurable.measure(constraints)
//        }
//        layout(constraints.maxWidth, constraints.maxHeight) {
//            placeables.forEach { placeable ->
//                placeable.placeRelative(x = , y = )
//            }
//        }
//    }

//    BoxWithConstraints(modifier = modifier) {
//        GrassBlock(blockInfo = blocks[0], modifier = Modifier.offset { IntOffset(0, 0) })
//        GrassBlock(blockInfo = blocks[1], modifier = Modifier.offset { IntOffset(0, 0) })
//    }
//
//    ConstraintLayout() {
//        val (block1, block2, block3) = createRefs()
//        GrassBlock(blockInfo = blocks[0], modifier = Modifier.constrainAs(block1) {
//            top.linkTo(parent.top)
//            start.linkTo(parent.start)
//        })
//        GrassBlock(blockInfo = blocks[1], modifier = Modifier.constrainAs(block2) {
//            top.linkTo(parent.top)
//            start.linkTo(block1.end)
//        })
//        GrassBlock(blockInfo = blocks[2], modifier = Modifier.constrainAs(block3) {
//            top.linkTo(parent.top)
//            start.linkTo(block2.end)
//        })
//
//    }

//    Layout(
//        content = {
//            GrassBlock(blockInfo = blocks[0])
//        }
//    ) { measurables, constraints ->
//        val block = measurables[0].measure(constraints)
//        layout(constraints.maxWidth, constraints.maxHeight) {
//            block.placeRelative(IntOffset(0, 10.dp.value.roundToInt() - block.height))
//        }
//    }

//    Layout(
//        modifier = modifier,
//    ) { measurables, constraints ->
//        val placeables = measurables.map { measurable ->
//            measurable.measure(constraints)
//        }
//        layout(constraints.maxWidth, constraints.maxHeight) {
//            var yPosition = 0
//
//            placeables.forEach { placeable ->
//                placeable.placeRelative(x = 0, y = yPosition)
//                yPosition += placeable.height
//            }
//        }
//    }
}
