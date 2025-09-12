package com.example.vknewsclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import com.example.vknewsclient.ui.theme.MainScreen
import com.example.vknewsclient.ui.theme.VkNewsClientTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsClientTheme {
                val launcher = rememberLauncherForActivityResult(
                    contract = VK.getVKAuthActivityResultContract(),
                    onResult = { result ->
                        when (result) {
                            is VKAuthenticationResult.Success -> {
                                Log.d("MYLOG", "Login success")
                            }

                            is VKAuthenticationResult.Failed -> {
                                Log.d("MYLOG", "Login failed")
                            }
                        }
                    })
                launcher.launch(listOf(VKScope.WALL))
                MainScreen()
            }
        }
    }
}



