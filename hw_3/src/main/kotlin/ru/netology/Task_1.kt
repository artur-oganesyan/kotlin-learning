package ru.netology

import kotlin.math.absoluteValue

fun main() {
    agoToText(59).also(::println)
}

fun agoToText(seconds: Int) = when (seconds) {
    in 0..59 -> "только что"
    in 60..3599 -> "${pluralForm(seconds / 60, "минуту", "минуты", "минут")} назад"
    in 3600..86399 -> "в сети ${pluralForm(seconds / 3600, "час", "часа", "часов")} назад"
    in 86400..172799 -> "сегодня"
    in 172800..259200 -> "вчера"
    else -> "давно"
}.let { "был(а) $it" }

fun pluralForm(value: Int, one: String, few: String, many: String): String {
    val absValue = value.absoluteValue % 100

    val word = when {
        absValue in 10..20 -> many
        absValue.toString().last().digitToInt() in 2..4 -> few
        absValue.toString().endsWith("1") -> one
        else -> many
    }
    return "$value $word"
}
