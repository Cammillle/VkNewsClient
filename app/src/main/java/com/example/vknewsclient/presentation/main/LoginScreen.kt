package com.example.vknewsclient.presentation.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vknewsclient.R
import com.vk.id.VKIDAuthFail
import com.vk.id.auth.VKIDAuthUiParams
import com.vk.id.onetap.common.OneTapStyle
import com.vk.id.onetap.common.button.style.OneTapButtonCornersStyle
import com.vk.id.onetap.common.button.style.OneTapButtonElevationStyle
import com.vk.id.onetap.common.button.style.OneTapButtonSizeStyle
import com.vk.id.onetap.compose.onetap.OneTap
import com.vk.id.onetap.compose.onetap.OneTapTitleScenario

@Composable
fun LoginScreen(
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(R.drawable.vk_logo),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(100.dp))
            ScreenWithVKIDButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenWithVKIDButton() {

    val authUIParams = VKIDAuthUiParams {
        scopes = setOf(
            "groups",
            "email",
            "phone"
        )

    }
    OneTap(
        authParams = authUIParams,
        onAuth = { oAuth, token ->
            Log.d("MYTAG", "Token: ${token.token}")
        },
        onFail = { _, fail ->
            when (fail) {
                is VKIDAuthFail.Canceled -> TODO()
                is VKIDAuthFail.FailedApiCall -> TODO()
                is VKIDAuthFail.FailedOAuthState -> TODO()
                is VKIDAuthFail.FailedRedirectActivity -> TODO()
                is VKIDAuthFail.NoBrowserAvailable -> TODO()
                else -> {}
            }
        },
        scenario = OneTapTitleScenario.SignUp,
        signInAnotherAccountButtonEnabled = false,
        style = OneTapStyle.Light(
            cornersStyle = OneTapButtonCornersStyle.Custom(2f),
            sizeStyle = OneTapButtonSizeStyle.SMALL_32,
            elevationStyle = OneTapButtonElevationStyle.Custom(4f)
        )
    )
}