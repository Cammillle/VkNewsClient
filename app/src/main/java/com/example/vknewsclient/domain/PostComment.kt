package com.example.vknewsclient.domain


data class PostComment(
    val id: Long,
    val firstName: String = "Author",
    val secondName: String = "Author",
    val avatarUrl: String,
    val commentText: String = "Long comment text",
    val publicationDate: String
)