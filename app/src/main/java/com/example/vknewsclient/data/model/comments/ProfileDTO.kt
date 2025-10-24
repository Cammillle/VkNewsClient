package com.example.vknewsclient.data.model.comments

import com.google.gson.annotations.SerializedName

data class ProfileDTO(
    @SerializedName("id") val id: Long,
    @SerializedName("photo_100") val avatarUrl: String,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String
)
