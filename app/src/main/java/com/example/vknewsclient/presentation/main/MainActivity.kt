package com.example.vknewsclient.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vknewsclient.ui.theme.VkNewsClientTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme {
                Scaffold { paddingValues ->
                    val viewModel: MainViewModel = viewModel()
                    val authState = viewModel.authState.observeAsState(AuthState.Initial)

                    val launcher = rememberLauncherForActivityResult(
                        contract = VK.getVKAuthActivityResultContract(),
                        onResult = { result ->
                            viewModel.performAuthResult(result)
                        })

                    when (authState.value) {
                        is AuthState.Authorized -> {
                            MainScreen()
                        }

                        is AuthState.NotAuthorized -> {
                            LoginScreen(
                                paddingValues = paddingValues,
                                onLoginClick = {
                                    launcher.launch(listOf(VKScope.WALL, VKScope.FRIENDS))
                                }
                            )
                        }
                        else -> {}
                    }
                }

            }
        }
    }
}



