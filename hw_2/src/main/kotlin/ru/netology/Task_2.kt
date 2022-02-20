package ru.netology

fun main() {

    val likes = 61

    val people = if (likes.toString().endsWith("1")) "человеку" else "людям"

    println("Понравилось $likes $people")
}