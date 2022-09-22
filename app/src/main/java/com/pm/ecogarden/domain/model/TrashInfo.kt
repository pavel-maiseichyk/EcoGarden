package com.pm.ecogarden.trash_feature.domain.model

data class TrashInfo(
    val userId: Int,
    val paperAmount: Int,
    val glassAmount: Int,
    val plasticAmount: Int,
    val metalAmount: Int,
    val batteryAmount: Int,
)

val emptyTrashInfo = TrashInfo(
    userId = 0,
    paperAmount = 11,
    glassAmount = 22,
    plasticAmount = 33,
    metalAmount = 44,
    batteryAmount = 55,
)