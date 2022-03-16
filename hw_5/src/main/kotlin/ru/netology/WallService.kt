package ru.netology

object WallService {

    val posts = mutableListOf<Post>()
    var lastId = 0

    fun add(post: Post): Post = post.apply {
        id = ++lastId
        posts.add(this)
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        return if (index != -1) {
            posts[index] = post.copy(fromId = posts[index].fromId, date = posts[index].date)
            true
        } else false
    }
}