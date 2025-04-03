package algorithm.bruteforcesearch

import kotlin.test.Test
import java.time.LocalDate

class `통장 잔액 naver-cloud-202504TEST` {
    @Test
    fun test() {
        val transactions = listOf(
            Transaction(5000, LocalDate.of(2025, 1, 15)),
            Transaction(-3000, LocalDate.of(2025, 1, 20)),
            Transaction(-2000, LocalDate.of(2025, 1, 25)),
            Transaction(10000, LocalDate.of(2025, 2, 10)),
            Transaction(-8000, LocalDate.of(2025, 2, 15))
        )
        val monthlyFee = 1000
        val usageThreshold = 5000

        val finalBalance = calculateAccountBalanceEfficient(transactions, monthlyFee, usageThreshold)
        println("최종 통장 잔액: $finalBalance")
    }
}