package com.example.vknewsclient.presentation.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vk.id.AccessToken
import com.vk.id.VKID

class MainViewModel() : ViewModel() {

    private val _authState = MutableLiveData<AuthState>(AuthState.Initial)
    val authState: LiveData<AuthState> = _authState

    init {
        val token = VKID.instance.accessToken?.token
        val loggedIn = token != null
        Log.d("MainViewModel", "Token: $token")
        _authState.value = if (loggedIn) AuthState.Authorized else AuthState.NotAuthorized
    }

    fun performAuthResult(token: AccessToken?) {
        if (token != null) {
            _authState.postValue(AuthState.Authorized)
        } else {
            _authState.postValue(AuthState.NotAuthorized)
        }
    }
}