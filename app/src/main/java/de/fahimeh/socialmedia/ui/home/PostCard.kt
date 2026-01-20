package de.fahimeh.socialmedia.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.fahimeh.socialmedia.ui.theme.SocialMediaComposeTheme

@Composable
fun PostCard(
    username: String,
    likes: Int,
    description: String,
    onReport: () -> Unit,
    onShare: () -> Unit,
    onCopyLink: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isLiked by remember { mutableStateOf(false) }
    var likeCount by remember { mutableIntStateOf(likes) }
    var showOptions by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF2F2F2))
            .padding(bottom = 12.dp)
    ) {

        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = username,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = { showOptions = true }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More"
                )
            }
        }

        // Post Image placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(Color.LightGray)
        )

        // Actions
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    isLiked = !isLiked
                    likeCount += if (isLiked) 1 else -1
                }
            ) {
                Icon(
                    imageVector = if (isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Like",
                    tint = if (isLiked) Color.Red else Color.Black
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "Comment"
                )
            }

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share"
                )
            }
        }

        Text(
            text = "$likeCount likes",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Text(
            text = "$username $description",
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        if (showOptions) {
            PostOptionsSheet(
                onDismiss = { showOptions = false },
                onReport = {
                    showOptions = false
                    onReport()
                           },
                onShare = {
                    showOptions = false
                    onShare()
                          },
                onCopyLink = {
                    showOptions = false
                    onCopyLink()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    SocialMediaComposeTheme {
        PostCard(
            username = "alex_dev",
            likes = 120,
            description = "Sample post description",
            onReport = {},
            onShare = {},
            onCopyLink = {}
        )
    }
}
