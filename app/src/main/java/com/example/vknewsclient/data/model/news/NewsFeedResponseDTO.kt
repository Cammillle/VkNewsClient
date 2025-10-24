package com.example.vknewsclient.data.model.news

import com.google.gson.annotations.SerializedName

data class NewsFeedResponseDTO(
    @SerializedName("response") val newsFeedContentDTO: NewsFeedContentDTO
)
