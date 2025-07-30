package com.example.vknewsclient.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.vknewsclient.R
import com.example.vknewsclient.domain.StatisticItem
import com.example.vknewsclient.domain.StatisticType

@Composable
fun PostCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            PostHeader()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = stringResource(R.string.template_text))
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(R.drawable.post_content_image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(8.dp))
            Statistics()
        }
    }
}

@Composable
private fun PostHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.post_comunity_thumbnail),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "/dev/null",
                //color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "14:00",
                //color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun Statistics(
    statistics: List<StatisticItem>
) {
    Row {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
            IconWithText(
                iconResId = R.drawable.ic_views_count, text = viewsItem.count.toString()
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sharesItem = statistics.getItemByType(StatisticType.SHARES)
            IconWithText(
                iconResId = R.drawable.ic_views_count, text = sharesItem.count.toString()
            )
            val commentItem = statistics.getItemByType(StatisticType.COMMENTS)
            IconWithText(
                iconResId = R.drawable.ic_views_count, text = commentItem.count.toString()
            )
            val likesItem = statistics.getItemByType(StatisticType.LIKES)
            IconWithText(
                iconResId = R.drawable.ic_views_count, text = likesItem.count.toString()
            )
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException()
}

@Composable
private fun IconWithText(
    iconResId: Int,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(iconResId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewDarkPostCard() {
//    VkNewsClientTheme(
//        darkTheme = true
//    ) {
//        PostCard()
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewLightPostCard() {
//    VkNewsClientTheme(
//        darkTheme = false
//    ) {
//        PostCard()
//    }
//}