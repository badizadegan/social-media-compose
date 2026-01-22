package de.fahimeh.socialmedia.ui.home

data class PostUi(
    val username: String,
    val likes: Int,
    val description: String
)

object HomeDummyData {
    val stories = listOf("Alex", "Maria", "John", "Sara", "Emma", "David")

    val posts = listOf(
        PostUi("alex_dev", 128, "This is a sample post description"),
        PostUi("maria.design", 542, "Working on a new UI concept today"),
        PostUi("john_kotlin", 76, "Jetpack Compose is getting better every day")
    )
}
