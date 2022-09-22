package com.pm.ecogarden.data.remote

import com.pm.ecogarden.domain.model.ApiRequest
import com.pm.ecogarden.domain.model.ApiResponse
import com.pm.ecogarden.domain.model.UserUpdate

interface KtorApi {

    @POST("/token_verification")
    suspend fun verifyTokenOnBackend(
        @Body request: ApiRequest
    ): ApiResponse

    suspend fun getUserInfo(): ApiResponse

    @PUT("/update_user")
    suspend fun updateUser(
        @Body userUpdate: UserUpdate
    ): ApiResponse

    @DELETE("/delete_user")
    suspend fun deleteUser(): ApiResponse

    suspend fun clearSession(): ApiResponse
}