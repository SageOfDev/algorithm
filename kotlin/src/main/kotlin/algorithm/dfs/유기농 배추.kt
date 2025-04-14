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


    }
}