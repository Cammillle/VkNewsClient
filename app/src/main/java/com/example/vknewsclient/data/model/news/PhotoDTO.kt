package com.example.vknewsclient.data.model.news

import com.google.gson.annotations.SerializedName

data class PhotoDTO(
    @SerializedName("sizes") val photoUrls: List<PhotoUrlDTO>
)
