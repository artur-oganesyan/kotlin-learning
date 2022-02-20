package ru.netology

fun main() {

    val currentCheck = 100_00
    val previousCheck = 10_001_00
    val isMusicLover = true

    var checkWithAllDiscount = currentCheck
    checkWithAllDiscount = promoDiscount(previousCheck, checkWithAllDiscount)
    if (isMusicLover) checkWithAllDiscount = discountForMusicLover(checkWithAllDiscount)

    println("Сумма с учетом скидок: ${checkWithAllDiscount / 100} руб. ${checkWithAllDiscount % 100} коп.")
}


fun promoDiscount(check: Int, currentCheck: Int) =
    if (check in 1001_00..10_000_00) currentCheck - 100_00
    else if (check > 10_000_00) currentCheck - (currentCheck * 0.05).toInt()
    else currentCheck

fun discountForMusicLover(check: Int) = (check - (check * 0.01)).toInt()