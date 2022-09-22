package com.pm.ecogarden.domain.repository

import com.pm.ecogarden.domain.model.BlockInfo
import kotlinx.coroutines.flow.Flow

interface BlockRepository {

    suspend fun updateBlockInfo(blockInfo: BlockInfo)

    fun getBlocksInfo(): Flow<List<BlockInfo>>

  //x  suspend fun getBlockInfoById(blockId: Int): BlockEntity
}