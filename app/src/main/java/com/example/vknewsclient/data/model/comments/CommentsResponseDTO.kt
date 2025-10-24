package com.example.vknewsclient.data.model.comments

import com.google.gson.annotations.SerializedName

data class CommentsResponseDTO(
    @SerializedName("response") val response: CommentsResponseContentDTO
)