package com.pm.ecogarden.domain.repository

import com.pm.ecogarden.domain.model.ApiRequest
import com.pm.ecogarden.domain.model.ApiResponse
import com.pm.ecogarden.domain.model.UserUpdate
import com.pm.ecogarden.domain.model.BlockInfo
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean>

    suspend fun saveUserName(name: String)
    fun getUserName(): Flow<String>
    suspend fun saveGardenName(name: String)
    fun getGardenName(): Flow<String>
    suspend fun updateBlockInfo(blockInfo: BlockInfo)
    fun getBlocksInfo(): Flow<List<BlockInfo>>

    suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse
    suspend fun getUserInfoFromApi(): ApiResponse
    suspend fun updateUser(userUpdate: UserUpdate): ApiResponse
    suspend fun deleteUser(): ApiResponse
    suspend fun clearSession(): ApiResponse
}