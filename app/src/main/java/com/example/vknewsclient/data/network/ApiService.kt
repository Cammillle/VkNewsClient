package com.example.vknewsclient.data.network

import com.example.vknewsclient.data.model.LikesCountResponseDTO
import com.example.vknewsclient.data.model.NewsFeedResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("newsfeed.get?v=5.199")
    suspend fun loadRecommendations(
        @Query("access_token") token: String
    ): NewsFeedResponseDTO

    @GET("newsfeed.get?v=5.199")
    suspend fun loadRecommendations(
        @Query("access_token") token: String,
        @Query("start_from") startFrom: String
    ): NewsFeedResponseDTO

    @GET("likes.add?v=5.199?type=post")
    suspend fun addLike(
        @Query("access_token") token: String,
        @Query("type") type: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long
    ): LikesCountResponseDTO

    @GET("likes.delete?v=5.199?type=post")
    suspend fun deleteLike(
        @Query("access_token") token: String,
        @Query("type") type: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long
    ): LikesCountResponseDTO

}