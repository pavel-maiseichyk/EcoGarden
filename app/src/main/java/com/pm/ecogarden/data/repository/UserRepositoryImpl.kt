package com.pm.ecogarden.data.repository

import com.pm.ecogarden.data.remote.KtorApi
import com.pm.ecogarden.domain.model.ApiRequest
import com.pm.ecogarden.domain.model.ApiResponse
import com.pm.ecogarden.domain.model.UserUpdate
import com.pm.ecogarden.domain.repository.BlockRepository
import com.pm.ecogarden.domain.repository.DataStoreOperations
import com.pm.ecogarden.domain.repository.Repository
import com.pm.ecogarden.domain.model.BlockInfo
import kotlinx.coroutines.flow.Flow

class RepositoryImpl(
    private val dataStore: DataStoreOperations,
    private val blockRepository: BlockRepository,
    private val api: KtorApi
) : Repository {
    override suspend fun saveSignedInState(signedIn: Boolean) {
        dataStore.saveSignedInState(signedIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStore.readSignedInState()
    }

    override suspend fun saveUserName(name: String) {
        dataStore.saveUserName(name)
    }

    override fun getUserName(): Flow<String> {
        return dataStore.getUserName()
    }

    override suspend fun saveGardenName(name: String) {
        dataStore.saveGardenName(name)
    }

    override fun getGardenName(): Flow<String> {
        return dataStore.getGardenName()
    }

    override suspend fun updateBlockInfo(blockInfo: BlockInfo) {
        blockRepository.updateBlockInfo(blockInfo)
    }

    override fun getBlocksInfo(): Flow<List<BlockInfo>> {
        return blockRepository.getBlocksInfo()
    }

    override suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse {
        return try {
            api.verifyTokenOnBackend(request)
        } catch (e: Exception) {
            ApiResponse(
                success = false,
                error = e
            )
        }
    }

    override suspend fun getUserInfoFromApi(): ApiResponse {
        return try {
            api.getUserInfo()
        } catch (e: Exception) {
            ApiResponse(
                success = false,
                error = e
            )
        }
    }

    override suspend fun updateUser(userUpdate: UserUpdate): ApiResponse {
        return try {
            api.updateUser(userUpdate)
        } catch (e: Exception) {
            ApiResponse(
                success = false,
                error = e
            )
        }
    }

    override suspend fun deleteUser(): ApiResponse {
        return try {
            api.deleteUser()
        } catch (e: Exception) {
            ApiResponse(
                success = false,
                error = e
            )
        }
    }

    override suspend fun clearSession(): ApiResponse {
        return try {
            api.clearSession()
        } catch (e: Exception) {
            ApiResponse(
                success = false,
                error = e
            )
        }
    }
}