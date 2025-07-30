package com.example.vknewsclient.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Preview(showBackground = true)
@Composable
fun MainScreen() {

    Scaffold(
        bottomBar = {
            NavigationBar {
                Log.d("TEST", "NavigationBar")

                val selectedItemPosition = remember {
                    mutableIntStateOf(0)
                }
                val items = listOf(
                    NavigationItem.Home, NavigationItem.Favourite, NavigationItem.Profile
                )
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemPosition.intValue == index,
                        onClick = { selectedItemPosition.intValue = index },
                        icon = { Icon(item.icon, contentDescription = null) },
                        label = { Text(text = stringResource(item.titleResId)) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onBackground,
                            selectedTextColor = MaterialTheme.colorScheme.onBackground
                        )
                    )
                }
            }
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            PostCard(
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}