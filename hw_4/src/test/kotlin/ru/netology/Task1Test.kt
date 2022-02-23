package ru.netology

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class Task1Test {

    companion object {

        @JvmStatic
        fun providerForCalculateCommission() = listOf(
            Arguments.of(SenderType.VK_PAY, 1000_00, 0, 0, 0),
            Arguments.of(SenderType.MASTER_CARD, 1000_00, 0, 0, 0),
            Arguments.of(SenderType.MAESTRO, 1000_00, 0, 0, 0),
            Arguments.of(SenderType.VISA, 1000_00, 0, 0, 35_00),
            Arguments.of(SenderType.MIR, 1000_00, 0, 0, 35_00),
            Arguments.of(SenderType.MASTER_CARD, 1000_00, 600_001_00, 0, null),
        )

        @JvmStatic
        fun providerForTransferIsAvailable() = listOf(
            Arguments.of(true, SenderType.VK_PAY, 15_000_00, 0, 0),
            Arguments.of(false, SenderType.VK_PAY, 15_001_00, 0, 0),
            Arguments.of(true, SenderType.VK_PAY, 1000_00, 0, 40_000_00),
            Arguments.of(false, SenderType.VK_PAY, 1000_00, 0, 40_001_00),
            Arguments.of(true, SenderType.MASTER_CARD, 0, 150_000_00, 0),
            Arguments.of(false, SenderType.MAESTRO, 0, 150_001_00, 0),
            Arguments.of(true, SenderType.VISA, 0, 0, 600_000_00),
            Arguments.of(false, SenderType.MIR, 0, 0, 600_001_00),
        )

        @JvmStatic
        fun providerForCommissionForMasterCardAndMaestro() = listOf(
            Arguments.of(299_00, 21_79),
            Arguments.of(300_00, 0),
            Arguments.of(75_000_00, 0),
            Arguments.of(75_001_00, 470_00),
        )

        @JvmStatic
        fun providerForCommissionForVisaAndMir() = listOf(
            Arguments.of(1000_00, 35_00),
            Arguments.of(4800_00, 36_00),
            Arguments.of(10000_00, 75_00),
        )
    }

    @ParameterizedTest
    @MethodSource("providerForCalculateCommission")
    fun calculateCommissionTest(
        senderType: SenderType,
        transfer: Int,
        transfersPerDay: Int,
        transfersPerMonth: Int,
        expectedCommission: Int?
    ) {
        assertEquals(
            expectedCommission,
            calculateCommission(senderType, transfer, transfersPerDay, transfersPerMonth)
        )
    }

    @Test
    fun calculateCommissionByDefaultParameters() {
        assertEquals(
            0,
            calculateCommission(currentTransfer = 1000_00)
        )
    }

    @ParameterizedTest
    @MethodSource("providerForTransferIsAvailable")
    fun transferIsAvailableTest(
        expectedResult: Boolean,
        senderType: SenderType,
        currentTransfer: Int,
        transfersPerDay: Int,
        transfersPerMonth: Int
    ) {
        assertEquals(
            expectedResult,
            transferIsAvailable(senderType, currentTransfer, transfersPerDay, transfersPerMonth)
        )
    }

    @ParameterizedTest
    @MethodSource("providerForCommissionForMasterCardAndMaestro")
    fun commissionForMasterCardAndMaestroTest(transfer: Int, expectedCommission: Int) {
        assertEquals(
            expectedCommission,
            commissionForMasterCardAndMaestro(transfer)
        )
    }

    @ParameterizedTest
    @MethodSource("providerForCommissionForVisaAndMir")
    fun commissionForVisaAndMirTest(transfer: Int, expectedCommission: Int) {
        assertEquals(
            expectedCommission,
            commissionForVisaAndMir(transfer)
        )
    }

}
