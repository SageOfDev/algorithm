package algorithm.bruteforcesearch

/**
 * 입력으로 List<Tuple(변동 금액, 날짜)> 이 들어온다. 변동 금액 입금이면 +, 출금(카드 사용)이면 - 이다.
 * 카드 회비는 매달 나가는데, 해당 월에 카드 사용 금액이  일정 금액 이상이면 카드 회비를 면제 해준다.
 * 해당 월의 카드 회비를 고려한 통장 잔액을 구하는 코드를 작성하라.
 */

const val MONTHLY_FEE = 5
const val CARD_USAGE_THRESHOLD = 100
const val CARD_USAGE_CNT_THRESHOLD = 3

data class MonthlyData(var monthSum: Int, var cardUsage: Int, var cardUsageCnt: Int = 0)

/**
 * D: YYYY-MM-DD
 */
fun solution(A: IntArray, D: Array<String>): Int {
    val size = A.size
    val dataArr = Array(12) { MonthlyData(0 ,0, 0) }

    for (i in 0 until size) {
        val idx = D[i].substring(5, 7).toInt() - 1
        dataArr[idx]
            .apply {
                this.monthSum += A[i]
                if (A[i] < 0) {
                    this.cardUsage += -A[i] // 절대값으로 저장
                    this.cardUsageCnt++
                }
            }
    }

    var totalBalance = 0

    dataArr.forEach { data ->
        totalBalance += data.monthSum
        if (!(data.cardUsage >= CARD_USAGE_THRESHOLD && data.cardUsageCnt >= CARD_USAGE_CNT_THRESHOLD)) {
            totalBalance -= MONTHLY_FEE
        }
    }

    return totalBalance
}
