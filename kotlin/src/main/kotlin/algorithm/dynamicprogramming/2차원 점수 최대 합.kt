package algorithm.dynamicprogramming

fun boj9465() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    repeat(i()) {
        val n = i()
        val arr = Array(2) { IntArray(n) { i() } }
        if (n > 1) {
            arr[0][1] += arr [1][0]
            arr[1][1] += arr [0][0]
        }
        for (i in 2 until n) {
            arr[0][i] += maxOf(arr[0][i - 2], arr[1][i - 2], arr[1][i - 1])
            arr[1][i] += maxOf(arr[1][i - 2], arr[0][i - 2], arr[0][i - 1])
        }
        println(maxOf(arr[0][n - 1], arr[1][n - 1]))
    }
}