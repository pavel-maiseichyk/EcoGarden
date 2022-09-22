package com.pm.ecogarden.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pm.ecogarden.data.local.blocks.BlockDao
import com.pm.ecogarden.data.local.blocks.BlockEntity
import com.pm.ecogarden.data.local.trash.MenuItemEntity
import com.pm.ecogarden.data.local.trash.StatsDao

@Database(
    entities = [
        BlockEntity::class,
        MenuItemEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class EcoDatabase : RoomDatabase() {
    abstract val blockDao: BlockDao
    abstract val statsDao: StatsDao

    companion object {
        const val DATABASE_NAME = "ecogarden.db"
    }
}