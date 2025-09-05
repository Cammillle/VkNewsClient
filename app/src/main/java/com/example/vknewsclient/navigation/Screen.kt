package com.example.vknewsclient.navigation


sealed class Screen(
    val route: String
) {
    object Home : Screen(ROUTE_HOME)  /*вложенный граф навигации, в котором будет 2 экрана*/
    object Comments : Screen(ROUTE_COMMENTS)
    object NewsFeed : Screen(ROUTE_NEWS_FEED)
    object Favourite : Screen(ROUTE_FAVOURITE)
    object Profile : Screen(ROUTE_PROFILE)

    private companion object {
        private const val ROUTE_HOME = "home"
        private const val ROUTE_COMMENTS = "comments"
        private const val ROUTE_NEWS_FEED = "news_feed"
        private const val ROUTE_FAVOURITE = "favourite"
        private const val ROUTE_PROFILE = "profile"
    }
}

