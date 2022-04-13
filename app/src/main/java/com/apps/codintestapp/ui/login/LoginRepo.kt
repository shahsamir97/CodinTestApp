package com.apps.codintestapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apps.codintestapp.model.LoginRequestBody
import com.apps.codintestapp.network.ApiService
import java.lang.Exception

class LoginRepo(private val apiService: ApiService) {

    private val _loginResponse = MutableLiveData<Any>()
    val loginResponse: LiveData<Any>
    get() = _loginResponse

    val showToast = MutableLiveData<String>()

    suspend fun login(requestBody: LoginRequestBody){
        try {
            val data = apiService.login(requestBody)
            _loginResponse.value = data
        }catch (e: Exception){
            showToast.value = "Something went wrong!"
        }
    }
}