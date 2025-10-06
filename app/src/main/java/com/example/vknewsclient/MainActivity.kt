package com.example.vknewsclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.vknewsclient.ui.theme.MainScreen
import com.example.vknewsclient.ui.theme.MyNumber
import com.example.vknewsclient.ui.theme.SideEffectTest
import com.example.vknewsclient.ui.theme.VkNewsClientTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            VkNewsClientTheme {
                val someState = rememberSaveable {
                    mutableStateOf(true)
                }
                Log.d("MainActivityTAG", "Recomposition ${someState.value}")

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
                LaunchedEffect(key1 = Unit, block = {
                    Log.d("MainActivityTAG", "LaunchedEffect")
                    delay(1000)
                })
                SideEffect {
                    Log.d("MainActivityTAG", "SideEffect")
                    //launcher.launch(listOf(VKScope.WALL))
                }
                Button(onClick = { someState.value = !someState.value }) {
                    Text("Change state")
                }
            }

        }


    }
}



