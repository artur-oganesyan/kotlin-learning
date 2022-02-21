package ru.netology

fun main() {
    val commission = calculateCommission(SenderType.MIR, 10_050_00)

    if (commission != null) println("Комиссия составила: ${commission / 100} руб. ${commission % 100} коп.")
    else println("Не удалось посчитать комиссию")
}

enum class SenderType {
    VK_PAY, MASTER_CARD, MAESTRO, VISA, MIR
}

fun calculateCommission(
    senderType: SenderType = SenderType.VK_PAY,
    currentTransfer: Int,
    transfersPerDay: Int = 0,
    transfersPerMonth: Int = 0
) = if (transferIsAvailable(senderType, currentTransfer, transfersPerDay, transfersPerMonth)) when (senderType) {
    SenderType.VK_PAY -> 0
    SenderType.MASTER_CARD, SenderType.MAESTRO -> commissionForMasterCardAndMaestro(currentTransfer)
    SenderType.VISA, SenderType.MIR -> commissionForVisaAndMir(currentTransfer)
} else null

fun transferIsAvailable(
    senderType: SenderType,
    currentTransfer: Int,
    transfersPerDay: Int,
    transfersPerMonth: Int
): Boolean {
    val cardsMaxPerDay = 150_000_00
    val cardsMaxPerMonth = 600_000_00
    val vkMaxTransfer = 15_000_00
    val vkMaxPerMonth = 40_000_00

    return when {
        senderType == SenderType.VK_PAY && currentTransfer <= vkMaxTransfer && transfersPerMonth <= vkMaxPerMonth -> true
        senderType != SenderType.VK_PAY && transfersPerDay <= cardsMaxPerDay && transfersPerMonth <= cardsMaxPerMonth -> true
        else -> false
    }
}

fun commissionForMasterCardAndMaestro(currentTransfer: Int): Int {
    val transferRangeForPromo = 300_00..75_000_00
    val commissionPercent = 0.006
    val fixCommission = 20_00

    return if (currentTransfer in transferRangeForPromo) 0 else (currentTransfer * commissionPercent).toInt() + fixCommission
}

fun commissionForVisaAndMir(currentTransfer: Int): Int {
    val commissionPercent = 0.0075
    val minCommission = 35_00

    val commission = (currentTransfer * commissionPercent).toInt()

    return if (commission < minCommission) minCommission else commission
}
