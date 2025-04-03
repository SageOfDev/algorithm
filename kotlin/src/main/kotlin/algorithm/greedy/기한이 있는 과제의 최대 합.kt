package algorithm.greedy

fun boj13904() {
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()
        val data = mutableListOf<Pair<Int, Int>>()
        for (i in 1..n) {
            val (d, w) = br.readLine().split(" ").map { it.toInt() }
            data.add(Pair(d, w))
        }
        data.sortedByDescending { it.first }

        var sum = 0
        for (date in n - 1 downTo 0) {
            val temp = mutableListOf<Pair<Int, Int>>()
            for ((idx, pair) in data.withIndex()) {
                val (d, w) = pair
                if (date < d) temp.add(Pair(idx, w))
                else break
            }
            val pair = temp.maxByOrNull { it.second }
            if (pair != null) {
                val (idx, w) = pair

                sum += w
                data.removeAt(idx)
            }
        }
        println(sum)
    }
}