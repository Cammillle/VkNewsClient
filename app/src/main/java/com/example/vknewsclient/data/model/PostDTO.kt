package com.example.vknewsclient.data.model

import com.google.gson.annotations.SerializedName

data class PostDTO(
    @SerializedName("id") val id: String?,
    @SerializedName("source_id") val communityId: Long,
    @SerializedName("isFavourite") val isFavourite: Boolean,
    @SerializedName("text") val text: String,
    @SerializedName("date") val date: Long,
    @SerializedName("likes") val likes: LikesDTO?,
    @SerializedName("comments") val comments: CommentsDTO?,
    @SerializedName("views") val views: ViewsDTO?,
    @SerializedName("reposts") val reposts: RepostsDTO?,
    @SerializedName("attachments") val attachments: List<AttachmentDTO>?
)