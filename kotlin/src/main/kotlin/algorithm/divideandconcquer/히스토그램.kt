package algorithm.divideandconcquer

import kotlin.math.max
import kotlin.math.min

private val heights = mutableListOf<Int>()

fun boj1725() {
    System.`in`.bufferedReader().use { br ->
        val n= br.readLine().toInt()
        repeat(n) {
            heights.add(br.readLine().toInt())
        }
        println(histogram(0, n))
    }
}

/**
 * 히스토그램 [s, e) 의 넓이를 구함
  */
fun histogram(s: Int, e: Int): Long  {
    if (s == e) return 0 // base case: 넓이 0
    if (s + 1 == e) return heights[s].toLong() // base case

    val mid = (s + e) / 2
    var result = max(histogram(s, mid), histogram(mid, e))
    var l = mid
    var r = mid
    var h = heights[mid]
    while (r - l + 1 < e - s) {
        val lh =  if (l > s) min(h, heights[l - 1]) else -1
        val rh =  if (r + 1 < e) min(h, heights[r + 1]) else -1
        h = if (lh > rh) {
            l--
            lh
        } else {
            r++
            rh
        }
        result = max((h.toLong() * (r - l + 1).toLong()) , result)
    }
    return result
}