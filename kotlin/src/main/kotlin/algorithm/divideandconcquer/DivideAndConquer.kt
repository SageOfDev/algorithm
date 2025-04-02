package algorithm.divideandconcquer

fun boj1629() {
    System.`in`.bufferedReader().use() { br ->
        val (a, b, c) = br.readLine().split(' ').map { it.toLong() }

        println(dac(a, b, c))
    }
}

fun dac(a: Long, b: Long, c: Long): Long {
    if (b == 1L) return a % c
    val before = dac(a, b / 2, c)
    return if (b % 2L == 0L) {
        (before * before) % c
    } else {
        ((before * before) % c * a % c) % c
    }
}