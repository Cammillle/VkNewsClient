package com.example.vknewsclient.data.mapper

import com.example.vknewsclient.data.model.NewsFeedResponseDTO
import com.example.vknewsclient.domain.FeedPost
import com.example.vknewsclient.domain.StatisticItem
import com.example.vknewsclient.domain.StatisticType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.absoluteValue

class NewsFeedMapper {

    fun mapResponseToPosts(responseDTO: NewsFeedResponseDTO): List<FeedPost> {
        val result = mutableListOf<FeedPost>()
        val posts = responseDTO.newsFeedContentDTO.posts
        val groups = responseDTO.newsFeedContentDTO.groups

        for (post in posts) {
            if (post.id == null) continue
            val group = groups.find { it.id == post.communityId.absoluteValue } ?: break
            val feedPost = FeedPost(
                id = post.id,
                communityId = post.communityId,
                communityName = group.name,
                publicationDate = mapTimestampToDate(post.date * 1000),
                communityImageUrl = group.imageUrl,
                contentText = post.text,
                contentImageUrl = post.attachments?.firstOrNull()?.photo?.photoUrls?.lastOrNull()?.url,
                statistics = listOf(
                    StatisticItem(type = StatisticType.LIKES, count = (post.likes?.count ?: 0)),
                    StatisticItem(type = StatisticType.VIEWS, count = post.views?.count ?: 0),
                    StatisticItem(type = StatisticType.COMMENTS, count = post.comments?.count ?: 0),
                    StatisticItem(type = StatisticType.SHARES, count = post.reposts?.count ?: 0)
                ),
                isLiked = post.likes.userLikes > 0
            )
            result.add(feedPost)
        }
        return result
    }

    private fun mapTimestampToDate(timestamp: Long): String {
        val date = Date(timestamp)
        return SimpleDateFormat("d MMMM yyyy, hh:mm", Locale.getDefault()).format(date)
    }

}