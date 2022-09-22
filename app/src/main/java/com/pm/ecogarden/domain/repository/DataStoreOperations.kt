package com.pm.ecogarden.auth.auth_one_click.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveSignedInState(isSignedIn: Boolean)
    fun readSignedInState(): Flow<Boolean>
}