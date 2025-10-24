package com.example.vknewsclient.data.model.news

import com.google.gson.annotations.SerializedName

data class LikesCountDTO(
    @SerializedName("likes") val count: Int
)