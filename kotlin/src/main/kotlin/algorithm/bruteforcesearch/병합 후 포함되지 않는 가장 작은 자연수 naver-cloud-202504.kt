package algorithm.bruteforcesearch

fun solution(A: IntArray, B: IntArray): Int {
    val n = A.size
    val present = BooleanArray(n + 2) { false }
    for (i in 0 until n) {
        val chosen = maxOf(A[i], B[i])
        if (chosen < present.size) present[chosen] = true
    }

    for (i in 1 until present.size) {
        if (!present[i]) return i
    }

    return present.size // unreachable
}