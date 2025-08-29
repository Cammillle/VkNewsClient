package com.example.vknewsclient.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vknewsclient.MainViewModel

@Composable
fun HomeScreen(
    viewModel: MainViewModel, paddingValues: PaddingValues
) {

    val feedPosts = viewModel.feedPosts.observeAsState(listOf())

    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        items(
            feedPosts.value, key = { it.id }) { feedPost ->
            val swipeToDismissBoxState = rememberSwipeToDismissBoxState(
                confirmValueChange = {
                    if (it == SwipeToDismissBoxValue.EndToStart) viewModel.remove(feedPost)
                    it != SwipeToDismissBoxValue.StartToEnd
                })
            SwipeToDismissBox(
                modifier = Modifier.animateItem(),
                state = swipeToDismissBoxState,
                enableDismissFromStartToEnd = false,
                backgroundContent = {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                            .background(Color.Red.copy(alpha = 0.5f)),
                    )
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = "Item deleted",
                        color = Color.White,
                        fontSize = 24.sp
                    )
                }) {
                PostCard(
                    modifier = Modifier.padding(8.dp),
                    feedPost = feedPost,
                    onCommentClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onLikeClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onShareClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onViewsClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    })
            }
        }
    }
}