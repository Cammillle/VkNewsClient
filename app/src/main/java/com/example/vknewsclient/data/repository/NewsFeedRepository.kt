package com.example.vknewsclient.data.repository

import com.example.vknewsclient.data.mapper.NewsFeedMapper
import com.example.vknewsclient.data.network.ApiFactory
import com.example.vknewsclient.domain.FeedPost
import com.example.vknewsclient.domain.StatisticItem
import com.example.vknewsclient.domain.StatisticType
import com.vk.id.VKID

class NewsFeedRepository() {
    private val token = VKID.instance.accessToken?.token

    private val mapper = NewsFeedMapper()
    private val apiService = ApiFactory.apiService

    private val _feedPosts = mutableListOf<FeedPost>()
    val feedPosts: List<FeedPost>
        get() = _feedPosts.toList()

    suspend fun loadRecommendations(): List<FeedPost> {
        val response = apiService.loadRecommendations(token = getAccessToken())
        val posts = mapper.mapResponseToPosts(response)
        _feedPosts.addAll(posts)
        return mapper.mapResponseToPosts(response)
    }

    suspend fun addLike(feedPost: FeedPost) {
        val response = apiService.addLike(
            token = getAccessToken(),
            type = "post",
            ownerId = feedPost.communityId,
            postId = feedPost.id
        )
        val newLikesCount = response.likes.count
        val newStatistics = feedPost.statistics.toMutableList().apply {
            removeIf { it.type == StatisticType.LIKES }
            add(StatisticItem(type = StatisticType.LIKES, count = newLikesCount))
        }
        val newPost = feedPost.copy(statistics = newStatistics, isLiked = true)
        val postIndex = _feedPosts.indexOf(feedPost)
        _feedPosts[postIndex] = newPost
    }

    suspend fun deleteLike(feedPost: FeedPost){
        val response = apiService.deleteLike(
            token = getAccessToken(),
            type = "post",
            ownerId = feedPost.communityId,
            postId = feedPost.id
        )
        val newLikesCount = response.likes.count
        val newStatistics = feedPost.statistics.toMutableList().apply {
            removeIf { it.type == StatisticType.LIKES }
            add(StatisticItem(type = StatisticType.LIKES, count = newLikesCount))
        }
        val newPost = feedPost.copy(statistics = newStatistics, isLiked = false)
        val postIndex = _feedPosts.indexOf(feedPost)
        _feedPosts[postIndex] = newPost
    }

    private fun getAccessToken(): String {
        return token ?: throw IllegalStateException("Token is null")
    }
}