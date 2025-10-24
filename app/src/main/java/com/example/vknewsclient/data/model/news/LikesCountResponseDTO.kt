package com.example.vknewsclient.data.model.news

import com.google.gson.annotations.SerializedName

data class LikesCountResponseDTO(
    @SerializedName("response") val likes: LikesCountDTO
)