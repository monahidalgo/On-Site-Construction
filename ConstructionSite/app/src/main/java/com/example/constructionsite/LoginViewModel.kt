package com.example.constructionsite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    private val _authenticationResult = MutableLiveData<Boolean>()
    val authenticationResult: LiveData<Boolean> = _authenticationResult

    fun login(username: String, password: String) {
        val result = loginRepository.login(username, password)
        result.observeForever { isAuthenticated ->
            _authenticationResult.value = isAuthenticated
        }
    }
}
