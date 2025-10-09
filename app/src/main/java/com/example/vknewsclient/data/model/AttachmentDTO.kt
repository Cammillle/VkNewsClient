package com.example.vknewsclient.data.model

import com.google.gson.annotations.SerializedName

data class AttachmentDTO(
    @SerializedName("photo") val photo: PhotoDTO?
)