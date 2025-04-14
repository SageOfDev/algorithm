package algorithm.dfs

fun boj1012() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    repeat(i()) {
        val m = i() // 가로
        val n = i() // 세로
        val k = i()

        val field = Array(m) { IntArray(n) { 0 } }
        val visited = Array(m) { BooleanArray(n) { false } }
        repeat(k) {
            val x = i()
            val y = i()
            field[x][y] = 1
        }
        var answer = 0

        fun dfs(x: Int, y: Int) {
            if (visited[x][y]) return

            visited[x][y] = true
            if (x + 1 < m && !visited[x + 1][y] && field[x + 1][y] == 1) dfs(x + 1, y)
            if (y + 1 < n && !visited[x][y + 1] && field[x][y + 1] == 1) dfs(x, y + 1)
            if (x - 1 > -1 && !visited[x - 1][y] && field[x - 1][y] == 1) dfs(x - 1, y)
            if (y - 1 > -1 && !visited[x][y - 1] && field[x][y - 1] == 1) dfs(x, y - 1)
        }

        for (x in 0 until m) {
            for (y in 0 until n) {
                if (!visited[x][y]) {
                    if (field[x][y] == 1) {
                        dfs(x, y)
                        answer++
                    } else {
                        visited[x][y] = true
                    }
                }
            }
        }
        println(answer)
    }
}
