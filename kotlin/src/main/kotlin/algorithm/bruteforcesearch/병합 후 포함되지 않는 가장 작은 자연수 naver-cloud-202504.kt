package algorithm.bruteforcesearch

fun smallestMissingPositive(arr1: IntArray, arr2: IntArray): Int {
    val n = arr1.size
    val merged = IntArray(n) { i -> minOf(arr1[i], arr2[i]) }

    val present = BooleanArray(n + 2)
    for (num in merged) {
        if (num < present.size - 1) present[num] = true
    }

    for (i in 1 until present.size) {
        if (!present[i]) return i
    }

    return present.size // unreachable
}