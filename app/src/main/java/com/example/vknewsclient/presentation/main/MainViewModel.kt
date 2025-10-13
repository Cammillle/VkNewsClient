package com.example.vknewsclient.presentation.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _authState = MutableLiveData<AuthState>(AuthState.Initial)
    val authState: LiveData<AuthState> = _authState

//    init {
//        val storage = VKPreferencesKeyValueStorage(application)
//        val token = VKAccessToken.restore(storage)
//        val loggedIn = token != null && token.isValid
//        Log.d("MainViewModel", "Token: ${token?.accessToken}")
//        _authState.value = if (loggedIn) AuthState.Authorized else AuthState.NotAuthorized
//    }
//
//    fun performAuthResult(result: VKAuthenticationResult) {
//        if (result is VKAuthenticationResult.Success) {
//            _authState.value = AuthState.Authorized
//        } else {
//            Log.d("MainViewModel", (result as VKAuthenticationResult.Failed).exception.toString())
//            _authState.value = AuthState.NotAuthorized
//        }
//    }
}