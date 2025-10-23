package com.example.vknewsclient.data.model

import com.google.gson.annotations.SerializedName

data class LikesCountDTO(
    @SerializedName("likes") val count: Int
)