package com.example.vknewsclient.navigation

import android.net.Uri
import com.example.vknewsclient.domain.FeedPost
import com.google.gson.Gson

sealed class Screen(
    val route: String
) {
    object Home : Screen(ROUTE_HOME)  /*вложенный граф навигации, в котором будет 2 экрана*/

    object Comments : Screen(ROUTE_COMMENTS) {
        private const val ROUTE_FOR_ARGS = "comments"

        fun getRouteWithArgs(feedPost: FeedPost): String {
            val feedPostJson = Gson().toJson(feedPost)
            return "$ROUTE_FOR_ARGS/${feedPostJson.encode()}"
        }
    }

    object NewsFeed : Screen(ROUTE_NEWS_FEED)
    object Favourite : Screen(ROUTE_FAVOURITE)
    object Profile : Screen(ROUTE_PROFILE)

    companion object {
        //const val KEY_FEED_POST_ID = "feed_post_id"
        //const val KEY_FEED_POST_CONTENT_TEXT = "feed_post_content_text"
        const val KEY_FEED_POST = "feed_post"

        private const val ROUTE_HOME = "home"
        private const val ROUTE_COMMENTS = "comments/${KEY_FEED_POST}"
        private const val ROUTE_NEWS_FEED = "news_feed"
        private const val ROUTE_FAVOURITE = "favourite"
        private const val ROUTE_PROFILE = "profile"
    }
}

//Экранирование специальных символов
fun String.encode(): String {
    return Uri.encode(this)
}

