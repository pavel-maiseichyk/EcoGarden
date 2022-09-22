package com.pm.ecogarden.data.repository

import com.pm.ecogarden.data.local.BlockEntity
import com.pm.ecogarden.garden.domain.model.BlockInfo
import kotlinx.coroutines.flow.Flow

interface BlockRepository {

    suspend fun updateBlockInfo(blockInfo: BlockInfo)

    fun getBlocksInfo(): Flow<List<BlockEntity>>

    suspend fun getBlockInfoById(blockId: Int): BlockEntity
}