package com.apps.codintestapp.network

import com.apps.codintestapp.model.LoginRequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService{

    //Return data type Any as no clue for login response was given.
    @POST("login")
    suspend fun login(@Body data: LoginRequestBody): Any
}