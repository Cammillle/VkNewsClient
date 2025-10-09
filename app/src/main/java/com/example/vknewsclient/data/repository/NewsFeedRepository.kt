package com.example.vknewsclient.data.repository

import android.app.Application
import com.example.vknewsclient.data.mapper.NewsFeedMapper
import com.example.vknewsclient.data.network.ApiFactory
import com.example.vknewsclient.domain.FeedPost
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken

class NewsFeedRepository(application: Application) {

    private val storage = VKPreferencesKeyValueStorage(application)
    private val token = VKAccessToken.restore(storage)

    private val mapper = NewsFeedMapper()
    private val apiService = ApiFactory.apiService

    suspend fun loadData(): List<FeedPost> {
        val response = apiService.get(token = getAccessToken())
        return mapper.mapResponseToPost(response)
    }

    suspend fun addLike(feedPost: FeedPost) {
        apiService.addLike(
            token = getAccessToken(),
            ownerId = feedPost.communityId,
            postId = feedPost.id
        )
    }

    private fun getAccessToken(): String {
        return token?.accessToken ?: throw IllegalStateException("Token is null")
    }
}