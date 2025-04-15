package algorithm.backtracking


fun boj1182() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val s = i()
    val seq = IntArray(n) { i() }

    var count = 0
    var sum = 0
    fun dfs(idx: Int) {
        if (idx == n) return

        if (sum + seq[idx] == s) count++

        dfs(idx + 1)

        sum += seq[idx]
        dfs(idx + 1)

        sum -= seq[idx]
    }
    dfs(0)

    println(count)
}