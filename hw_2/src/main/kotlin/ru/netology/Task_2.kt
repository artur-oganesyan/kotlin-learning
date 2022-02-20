package ru.netology

fun main() {

    val likes = 911

    val people = if (!likes.toString().endsWith("11") && likes.toString().endsWith("1")) "человеку" else "людям"

    println("Понравилось $likes $people")
}