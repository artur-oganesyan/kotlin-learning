package ru.netology

fun main() {

    val amount = 10999_00

    val minCommission = 35_00
    val percentCommission = 0.0075

    val preliminaryCommission = (amount * percentCommission).toInt()

    val finalCommission =
        if (amount * percentCommission > minCommission) preliminaryCommission
        else minCommission

    println("Комиссия составила: ${finalCommission / 100} руб. ${finalCommission % 100} коп.")

}
