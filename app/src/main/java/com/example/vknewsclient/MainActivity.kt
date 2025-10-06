package com.example.vknewsclient

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import com.example.vknewsclient.ui.theme.MainScreen
import com.example.vknewsclient.ui.theme.MyNumber
import com.example.vknewsclient.ui.theme.SideEffectTest
import com.example.vknewsclient.ui.theme.VkNewsClientTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold { paddingValues ->
                VkNewsClientTheme {
                    SideEffectTest(
                        paddingValues = paddingValues,
                        MyNumber(2)
                    )
                }
            }

        }
    }
}



