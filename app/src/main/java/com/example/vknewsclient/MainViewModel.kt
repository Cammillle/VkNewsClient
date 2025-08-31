package com.example.vknewsclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vknewsclient.domain.FeedPost
import com.example.vknewsclient.domain.PostComment
import com.example.vknewsclient.domain.StatisticItem
import com.example.vknewsclient.ui.theme.HomeScreenState
import com.example.vknewsclient.ui.theme.NavigationItem

class MainViewModel : ViewModel() {
    private val comments = mutableListOf<PostComment>().apply {
        repeat(10) {
            add(
                PostComment(id = it)
            )
        }
    }

    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(
                FeedPost(
                    id = it
                )
            )
        }
    }
    private val initialState = HomeScreenState.Posts(feedPosts = sourceList)

    private val _screenState = MutableLiveData<HomeScreenState>(initialState)
    val screenState: LiveData<HomeScreenState> = _screenState

    private var savedState:HomeScreenState = initialState

    fun showComments(feedPost: FeedPost) {
        savedState = _screenState.value
        _screenState.value = HomeScreenState.Comments(comments = comments, feedPost = feedPost)
    }

    fun closeComments() {
        _screenState.value = savedState
    }

    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val currentState = screenState.value
        if (currentState !is HomeScreenState.Posts) return

        val oldPosts = currentState.feedPosts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = HomeScreenState.Posts(feedPosts = newPosts)
    }

    fun remove(feedPost: FeedPost) {
        val currentState = screenState.value
        if (currentState !is HomeScreenState.Posts) return

        val oldPosts = currentState.feedPosts.toMutableList()
        oldPosts.remove(feedPost)
        _screenState.value = HomeScreenState.Posts(oldPosts)
    }



}