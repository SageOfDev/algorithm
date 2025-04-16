package algorithm.backtracking

fun boj17136() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
     nextToken()
     return nval.toInt()
    }

    val colorPaper = intArrayOf(0) + IntArray(5) { 5 }
    var numOfOnes = 0
    var coveredOnes = 0
    val paper = Array(10) {
        IntArray(10) {
            i().also { if (it == 1) numOfOnes++ }
        }
    }

    var minUse = Int.MAX_VALUE

    fun canUseColorPaper(x: Int, y: Int, size: Int): Boolean {
        if (colorPaper[size] <= 0) return false
        if (x + size > 10 || y + size > 10) return false
        for (i in y until y + size) {
            for (j in x until x + size) {
                if (paper[i][j] == 0) return false
            }
        }
        return true
    }

    fun changePaper(x: Int, y: Int, size: Int) {
        for (i in y until y + size) {
            for (j in x until x + size) {
                paper[i][j] = paper[i][j] xor 1
            }
        }
    }

    fun dfs(x: Int, y: Int) {
        val currUse = 25 - colorPaper.sum()
        if (currUse >= minUse) return

        if (coveredOnes == numOfOnes) minUse = minOf(minUse, currUse)

        if (x > 9 || y > 9) return

        if (paper[y][x] == 0) {
            if (x == 9) dfs(0, y + 1)
            else dfs(x + 1, y)
        }

        for (size in 5 downTo 1) {
            if (canUseColorPaper(x, y, size)) {
                changePaper(x, y, size)
                colorPaper[size] -= 1
                coveredOnes += size * size

                if (x + size > 9) dfs(0, y + 1)
                else dfs(x + size, y)

                changePaper(x, y, size)
                colorPaper[size] += 1
                coveredOnes -= size * size
            }
        }
    }

    dfs(0, 0)
    if (minUse == Int.MAX_VALUE) minUse = -1

    println(minUse)
}
