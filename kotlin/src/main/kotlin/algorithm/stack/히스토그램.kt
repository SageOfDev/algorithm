package algorithm.stack

fun boj1725() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Double {
        nextToken()
        return nval
    }
    val n = i().toInt()
    val histogram = List(n) { i().toLong() } + listOf(0L)
    val stk = ArrayDeque<Pair<Int, Long>>()
    var answer = 0L

    for ((endX, currY) in histogram.withIndex()) {
        var startX = endX
        while (stk.isNotEmpty() && stk.last().second > currY) {
            val (prevStartX, prevY)= stk.removeLast()
            startX = prevStartX // x left sliding until prevY > currY
            answer = maxOf(answer, (endX - startX) * prevY)
        }
        stk.addLast(startX to currY)
    }

    println(answer)
}