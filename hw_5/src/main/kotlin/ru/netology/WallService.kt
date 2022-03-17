package ru.netology

object WallService {

    val posts = mutableListOf<Post>()
    val comments = mutableListOf<Comment>()
    var lastPostId = 0
    var lastCommentId = 0

    fun add(post: Post): Post = post.apply {
        id = ++lastPostId
        posts.add(this)
    }

    fun update(post: Post): Boolean {
        val index = posts.indexOfFirst { it.id == post.id }
        return if (index != -1) {
            posts[index] = post.copy(fromId = posts[index].fromId, date = posts[index].date)
            true
        } else false
    }

    fun createComment(comment: Comment): Comment {
        posts.singleOrNull { it.id == comment.postId } ?: throw PostNotFoundException()
        return comment.apply {
            id = ++lastCommentId
            comments.add(this)
        }
    }

    class PostNotFoundException : RuntimeException() {
        override val message = "Post not found"
    }
}