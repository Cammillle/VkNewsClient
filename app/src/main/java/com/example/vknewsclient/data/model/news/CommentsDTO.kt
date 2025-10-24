package com.example.vknewsclient.data.model.news

import com.google.gson.annotations.SerializedName

data class CommentsDTO(
    @SerializedName("count") val count: Int
)
