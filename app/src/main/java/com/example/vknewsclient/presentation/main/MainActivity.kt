package com.example.vknewsclient.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vknewsclient.ui.theme.VkNewsClientTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme {
                val viewModel: MainViewModel = viewModel()
                val authState = viewModel.authState.observeAsState(AuthState.Initial)

                Scaffold { paddingValues ->
                    when (authState.value) {
                        is AuthState.Authorized -> {
                            MainScreen()
                        }

                        is AuthState.NotAuthorized -> {
                            LoginScreen(
                                paddingValues = paddingValues,
                                viewModel
                            )
                        }

                        else -> {}
                    }
                }

            }
        }
    }
}



