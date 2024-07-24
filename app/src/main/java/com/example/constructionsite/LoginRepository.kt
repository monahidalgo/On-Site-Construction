package com.example.constructionsite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LoginRepository {
    fun login(username: String, password: String): LiveData<Boolean> {
        // implement authentication logic here
        // for simplicity, assume authentication is successful
        return MutableLiveData(true)
    }
}