package com.pm.ecogarden.data.repository

import com.pm.ecogarden.data.local.EcoDatabase
import com.pm.ecogarden.domain.repository.BlockRepository
import com.pm.ecogarden.domain.model.BlockInfo
import com.pm.ecogarden.util.toBlockEntity
import com.pm.ecogarden.util.toBlockInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BlockRepositoryImpl @Inject constructor(
    private val db: EcoDatabase
) : BlockRepository {

    private val dao = db.blockDao

    override suspend fun updateBlockInfo(blockInfo: BlockInfo) {
        dao.updateBlockInfo(blockInfo.toBlockEntity())
    }

    override fun getBlocksInfo(): Flow<List<BlockInfo>> {
        return dao.getBlocksInfo().map { list ->
            if (list.isEmpty()) {
                getBlocksInfo()
            }
            list.map { it.toBlockInfo() }
        }
    }
}