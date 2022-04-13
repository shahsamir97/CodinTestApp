package com.apps.codintestapp.model

data class LoginRequestBody(
    val device_token: String,
    val device_type: String,
    val grant_type: String,
    val password: String,
    val username: String
)