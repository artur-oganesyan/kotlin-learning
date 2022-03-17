package ru.netology

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WallServiceTest {

    @Test
    fun add() {
        val post = Post(
            null,
            1,
            1, null,
            1,
            null,
            null,
            null,
            true,
            null,
            null,
            Likes(1, true, true, true),
            Reposts(1, true),
            Views(1),
            "",
            null,
            null,
            true,
            true,
            true,
            true,
            true,
            true,
            null,
            null
        )

        val newPost = WallService.add(post)
        assertEquals(WallService.lastPostId, newPost.id)
    }

    @Test
    fun update() {
        val post = Post(
            null,
            1,
            1,
            1,
            1,
            "",
            1,
            1,
            true,
            Comments(1, true, true, true, true),
            Copyright(1, "", "", ""),
            Likes(1, true, true, true),
            Reposts(1, true),
            Views(1),
            "",
            listOf(Photo(1, 2, 3, 4, "5", 6)),
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            Donut(true, 1, Placeholder(""), true, ""),
            1
        )

        val newPost = WallService.add(post)
        assertTrue(WallService.update(newPost.copy(text = "test")))
    }

    @Test
    fun updateIfPostAbsent() {
        val post = Post(
            999,
            1,
            1,
            1,
            1,
            "",
            1,
            1,
            true,
            Comments(1, true, true, true, true),
            Copyright(1, "", "", ""),
            Likes(1, true, true, true),
            Reposts(1, true),
            Views(1),
            "",
            listOf(Photo(1, 2, 3, 4, "5", 6)),
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            Donut(true, 1, Placeholder(""), true, ""),
            1
        )

        assertFalse(WallService.update(post))
    }

    @Test
    fun createComment(){
        val post = Post(
            999,
            1,
            1,
            1,
            1,
            "",
            1,
            1,
            true,
            Comments(1, true, true, true, true),
            Copyright(1, "", "", ""),
            Likes(1, true, true, true),
            Reposts(1, true),
            Views(1),
            "",
            listOf(Photo(1, 2, 3, 4, "5", 6)),
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            Donut(true, 1, Placeholder(""), true, ""),
            1
        )
        val id = WallService.add(post).id
        val comment = Comment(
            id = 1,
            postId = id!!,
            text = "test"
        )
        WallService.createComment(comment)
        assertEquals(WallService.comments[0].text, "test")
    }

    @Test
    fun createCommentShouldThrow() {
        val comment = Comment(
            id = 1,
            postId = 111,
            text = "test"
        )
        assertThrows(
            WallService.PostNotFoundException::class.java
        ) {
            WallService.createComment(comment)
        }
    }

}