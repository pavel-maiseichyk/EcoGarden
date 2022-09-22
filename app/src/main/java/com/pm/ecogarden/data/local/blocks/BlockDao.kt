package com.pm.ecogarden.data.local.blocks

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BlockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBlockInfo(blockEntity: BlockEntity)

    @Query("SELECT * FROM BlockEntity")
    fun getBlocksInfo(): Flow<List<BlockEntity>>
}