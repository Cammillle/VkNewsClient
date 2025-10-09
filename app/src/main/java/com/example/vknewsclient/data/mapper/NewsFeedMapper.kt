package com.example.vknewsclient.data.mapper

import com.example.vknewsclient.data.model.NewsFeedResponseDTO
import com.example.vknewsclient.domain.FeedPost
import com.example.vknewsclient.domain.StatisticItem
import com.example.vknewsclient.domain.StatisticType
import kotlin.math.absoluteValue

class NewsFeedMapper {

    fun mapResponseToPost(responseDTO: NewsFeedResponseDTO): List<FeedPost> {
        val result = mutableListOf<FeedPost>()
        val posts = responseDTO.newsFeedContentDTO.posts
        val groups = responseDTO.newsFeedContentDTO.groups

        for (post in posts) {
            if(post.id == null) continue
            val group = groups.find { it.id == post.communityId.absoluteValue } ?: break
            val feedPost = FeedPost(
                id = post.id,
                communityName = group.name,
                publicationDate = post.date.toString(),
                communityImageUrl = group.imageUrl,
                contentText = post.text,
                contentImageUrl = post.attachments?.firstOrNull()?.photo?.photoUrls?.lastOrNull()?.url,
                statistics = listOf(
                    StatisticItem(type = StatisticType.LIKES, count = (post.likes?.count ?: 0)),
                    StatisticItem(type = StatisticType.VIEWS, count = post.views?.count ?: 0),
                    StatisticItem(type = StatisticType.COMMENTS, count = post.comments?.count ?: 0),
                    StatisticItem(type = StatisticType.SHARES, count = post.reposts?.count ?: 0)
                )
            )
            result.add(feedPost)
        }
        return result
    }

}