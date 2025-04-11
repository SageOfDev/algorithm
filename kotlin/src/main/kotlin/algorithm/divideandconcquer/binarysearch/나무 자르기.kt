package algorithm.divideandconcquer.binarysearch



fun boj2805() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val m = i().toLong()

    val heights = Array(n) { i().toLong() }
    var l = 0L
    var r = heights.max() + 1

    while (l + 1 < r) {
        var sum = 0L
        val h = (l + r) shr 1

        for (height in heights) {
            if (height > h) sum += height - h
        }

        if (sum < m) {
            r = h
        } else {
            l = h
        }
    }

    println(l)
}
