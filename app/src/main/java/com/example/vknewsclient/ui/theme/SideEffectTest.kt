package com.example.vknewsclient.ui.theme

import android.os.Handler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SideEffectTest(
    paddingValues: PaddingValues, number: MyNumber
) {
    Column {
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 5.dp)
        ) {
            repeat(5) {
                item {
                    Text("Number: ${number.a}")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Handler().postDelayed({
            number.a = 4
        }, 3000)
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 5.dp)
        ) {
            repeat(5) {
                item {
                    Text("Number: ${number.a}")
                }
            }
        }
    }
}

data class MyNumber(
    var a: Int
)