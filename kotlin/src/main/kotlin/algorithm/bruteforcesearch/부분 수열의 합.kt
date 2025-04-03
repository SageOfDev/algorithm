package algorithm.bruteforcesearch

fun boj1182() {
    System.`in`.bufferedReader().use { br ->
        val (n, s) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }
        var count = 0
        for (i in 1 until (1 shl n)) {
            var sum = 0
            for (j in 0 until n) {
                if (i and (1 shl j) != 0) {
                    sum += arr[j]
                }
            }
            if (sum == s) {
                count++
            }
        }
        println(count)
    }
}