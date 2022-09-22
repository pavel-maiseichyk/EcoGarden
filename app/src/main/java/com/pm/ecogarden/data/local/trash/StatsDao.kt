package com.pm.ecogarden.data.local.trash

import androidx.room.Insert
import androidx.room.Query

interface MenuItemsDao {

    @Query("SELECT * FROM MenuItemEntity")
    fun getMenuItemsInfo(): List<MenuItemEntity>

    @Insert
    fun insertItem(item: MenuItemEntity)
}