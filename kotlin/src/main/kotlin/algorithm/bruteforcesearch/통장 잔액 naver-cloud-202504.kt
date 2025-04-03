package algorithm.bruteforcesearch

import java.time.LocalDate
import java.time.YearMonth

data class Transaction(val flow: Int, val date: LocalDate)
data class MonthlyData(var monthSum: Int, var cardUsage: Int)

/**
 * 입력으로 List<Tuple(변동 금액, 날짜)> 이 들어온다. 변동 금액 입금이면 +, 출금(카드 사용)이면 - 이다.
 * 카드 회비는 매달 나가는데, 해당 월에 카드 사용 금액이  일정 금액 이상이면 카드 회비를 면제 해준다.
 * 해당 월의 카드 회비를 고려한 통장 잔액을 구하는 코드를 작성하라.
 */
fun calculateAccountBalanceEfficient(transactions: List<Transaction>, monthlyFee: Int, usageThreshold: Int): Int {
    val dataMap = mutableMapOf<YearMonth, MonthlyData>()

    transactions.forEach { transaction ->
        val date = YearMonth.from(transaction.date)
        dataMap.getOrPut(date) { MonthlyData(0 ,0) }
            .apply {
                this.monthSum += transaction.flow
                if (transaction.flow < 0) this.cardUsage += transaction.flow
            }
    }

    var totalBalance = 0
    dataMap.forEach { (_, data) ->
        totalBalance += data.monthSum
        if (data.cardUsage < usageThreshold) totalBalance -= monthlyFee
    }

    return totalBalance
}