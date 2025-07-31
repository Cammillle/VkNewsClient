package com.example.vknewsclient.ui.theme

import android.util.Log

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.vknewsclient.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val selectedNavItem by viewModel.selectedNavItem.observeAsState(NavigationItem.Home)

    Scaffold(
        bottomBar = {
            NavigationBar {
                Log.d("TEST", "NavigationBar")

                val items = listOf(
                    NavigationItem.Home, NavigationItem.Favourite, NavigationItem.Profile
                )
                items.forEach { item ->
                    NavigationBarItem(
                        selected = selectedNavItem == item,
                        onClick = { viewModel.selectNavItem(item) },
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
        when (selectedNavItem) {
            NavigationItem.Home -> {
                HomeScreen(viewModel, paddingValues)
            }
            NavigationItem.Profile -> Text("Profile", color = Color.Black)
            NavigationItem.Favourite -> Text("Favourite", color = Color.Black)
        }
    }
}