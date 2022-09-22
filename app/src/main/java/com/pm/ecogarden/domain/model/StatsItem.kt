package com.pm.ecogarden.data.local.trash

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuItemEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val amount: Int,
    val count: Int,
    val trashType: String
)