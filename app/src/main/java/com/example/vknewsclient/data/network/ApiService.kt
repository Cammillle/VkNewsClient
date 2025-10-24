package com.example.vknewsclient.data.network

import com.example.vknewsclient.data.model.news.LikesCountResponseDTO
import com.example.vknewsclient.data.model.news.NewsFeedResponseDTO
import com.example.vknewsclient.data.model.comments.CommentsResponseDTO
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

    @GET("newsfeed.ignoreItem?v=5.199")
    suspend fun ignorePost(
        @Query("access_token") token: String,
        @Query("type") type: String = "wall",
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long
    )

    @GET("wall.getComments?v=5.199&extended=1&fields=photo_100")
    suspend fun getComments(
        @Query("access_token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("post_id") postId: Long
    ): CommentsResponseDTO


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