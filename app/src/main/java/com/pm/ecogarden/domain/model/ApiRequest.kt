package com.pm.ecogarden.auth.auth_one_click.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiRequest(
    val tokenId: String
)
