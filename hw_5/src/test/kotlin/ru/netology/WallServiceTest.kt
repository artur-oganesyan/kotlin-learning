package ru.netology

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
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
        assertEquals(WallService.lastId, newPost.id)
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
            listOf(PhotoAttachment()),
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
            listOf(PhotoAttachment()),
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


}