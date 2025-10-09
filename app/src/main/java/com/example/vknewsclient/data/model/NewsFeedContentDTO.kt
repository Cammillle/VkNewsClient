package com.example.vknewsclient.data.model

import com.google.gson.annotations.SerializedName

data class NewsFeedContentDTO(
    @SerializedName("items") val posts: List<PostDTO>,
    @SerializedName("groups") val groups: List<GroupDTO>
)
