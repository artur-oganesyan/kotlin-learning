package ru.netology

data class Comment(
    var id: Int?,
    val postId: Int,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String,
    val donut: DonutComment = DonutComment(),
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachments: List<Attachment>? = null,
    val parentsStack: List<Int>? = null,
    val thread: Thread = Thread()
)
data class Thread(
    val count: Int = 0,
    val items: List<Any>? = null,
    val can_post: Boolean = true,
    val show_reply_button: Boolean = true,
    val groups_can_post: Boolean = true
)
data class DonutComment(
    val is_don: Boolean = true,
    val placeholder: String? = null
)