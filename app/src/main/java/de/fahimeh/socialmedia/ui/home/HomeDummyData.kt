package de.fahimeh.socialmedia.ui.home

data class StoryUi(
    val name: String,
    val imageUrl: String
)

data class PostUi(
    val username: String,
    val likes: Int,
    val description: String,
    val userImageUrl: String,
    val postImageUrl: String
)

object HomeDummyData {
    val stories = listOf(
        StoryUi("Alex", "https://i.pravatar.cc/150?img=12"),
        StoryUi("Maria", "https://i.pravatar.cc/150?img=47"),
        StoryUi("Anna", "https://i.pravatar.cc/150?img=32"),
        StoryUi("Sara", "https://i.pravatar.cc/150?img=5"),
        StoryUi("Emma", "https://i.pravatar.cc/150?img=9"),
        StoryUi("David", "https://i.pravatar.cc/150?img=15")
    )

    val posts = listOf(
        PostUi(
            username = "alex_dev",
            likes = 128,
            description = "This is a sample post description",
            userImageUrl = "https://i.pravatar.cc/150?img=12",
            postImageUrl = "https://picsum.photos/seed/post1/800/600"
        ),
        PostUi(
            username = "maria.design",
            likes = 542,
            description = "Working on a new UI concept today",
            userImageUrl = "https://i.pravatar.cc/150?img=47",
            postImageUrl = "https://picsum.photos/seed/post2/800/600"
        ),
        PostUi(
            username = "anna_kotlin",
            likes = 76,
            description = "Jetpack Compose is getting better every day",
            userImageUrl = "https://i.pravatar.cc/150?img=32",
            postImageUrl = "https://picsum.photos/seed/post3/800/600"
        )
    )
}
