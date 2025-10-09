package com.example.vknewsclient.data.network

import com.example.vknewsclient.data.model.NewsFeedResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("newsfeed.get?v=5.199")
    suspend fun get(
        @Query("access_token") token: String
    ): NewsFeedResponseDTO

    @GET("likes.add?v=5.199?type=post")
    suspend fun addLike(
        @Query("access_token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long
    )

}