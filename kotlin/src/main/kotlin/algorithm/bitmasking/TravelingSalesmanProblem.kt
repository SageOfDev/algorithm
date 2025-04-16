package algorithm.bitmasking


const val IMPOSSIBLE = 1000000 * 16
fun boj2098() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val w = Array(n) { IntArray(n) { i() } }
    val dp = Array(n) { IntArray(1 shl n) { -1 } } // -1: 계산하기 전의 상태
    val allVisited = (1 shl n) - 1

    // 현재 curr 에 있고 visited 에 속한 마을들을 이미 방문하였을 때, 방문하지 않은 마을들을 순회하여 시작점(0)으로 돌아가는 추가 비용
    fun tsp(curr: Int, visited: Int): Int {
        if (dp[curr][visited] != -1) return dp[curr][visited]

        // base case: 모든 마을을 방문한 경우
        if (visited == allVisited) {
            val nextCost = w[curr][0]
            dp[curr][visited] = if (nextCost == 0) IMPOSSIBLE else nextCost
            return dp[curr][visited]
        }

        var minCost = IMPOSSIBLE
        for ((nextTown, nextCost) in w[curr].withIndex()) {
            if ((visited and (1 shl nextTown)) != 0 || nextCost == 0) continue // 방문했거나 갈 수 없는 경우

            minCost = minOf(minCost, tsp(nextTown, visited or (1 shl nextTown)) + w[curr][nextTown])
        }
        dp[curr][visited] = minCost
        return dp[curr][visited]
    }

    println(tsp(0 , 1))
}