package com.apps.codintestapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.codintestapp.model.LoginRequestBody
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: LoginRepo) : ViewModel() {

    val loginResult = repo.loginResponse

    val showToast = repo.showToast

   fun loginUser(userName: String, password:String){
       val data = LoginRequestBody(
           device_token = "test.token.test",
           device_type = "ANDROID",
           grant_type = "password",
           password = password,
           username = userName
       )

       viewModelScope.launch {
           repo.login(data)
       }
   }
}