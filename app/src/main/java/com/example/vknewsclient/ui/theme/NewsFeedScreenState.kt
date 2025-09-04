package com.example.vknewsclient.ui.theme

import com.example.vknewsclient.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial:NewsFeedScreenState()

    data class Posts(val feedPosts: List<FeedPost>) : NewsFeedScreenState()

}