package algorithm.bfs


fun boj2644() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val a = i()
    val b = i()
    val m = i()

    val graph = Array(n + 1) { IntArray(n + 1) { 0 } }
    val visited = BooleanArray(n + 1) { false }
    repeat(m) {
        val x = i()
        val y = i()
        graph[x][y] = 1
        graph[y][x] = 1
    }

    fun bfs(start: Int, end: Int): Int {
        val queue = ArrayDeque<Int>()
        val distances = IntArray(n + 1) { -1 }

        queue.add(start)
        visited[start] = true
        distances[start] = 0

        while (queue.isNotEmpty()) {
            val x = queue.removeFirst()
            for (y in 1 .. n) {
                if (!visited[y] && graph[x][y] == 1) {
                    queue.add(y)
                    visited[y] = true
                    distances[y] = distances[x] + 1

                    if (y == end) return distances[y]
                }
            }
        }

        return -1
    }

    val distance = bfs(a, b)

    println(distance)
}