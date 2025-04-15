package algorithm.bfs

fun boj2178() {
    val br = System.`in`.bufferedReader()
    val st = java.io.StreamTokenizer(br)
    val n = st.nextToken().let { st.nval.toInt() }
    val m = st.nextToken().let { st.nval.toInt() }

    val maze = Array(n) { CharArray(m) }
    for (y in 0 until n) {
        val line = br.readLine()
        for (x in 0 until m) {
            maze[y][x] = line[x]
        }
    }

    val visited = Array(n) { BooleanArray(m) }
    val queue = ArrayDeque<Pair<Int, Int>>()

    fun bfs(x: Int, y: Int): Int {
        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, -1, 0, 1)
        val distances = Array(n) { IntArray(m) { 0 } }

        visited[y][x] = true
        queue.add(y to x)
        distances[y][x] += 1

        while (queue.isNotEmpty()) {
            val (currY, currX) = queue.removeFirst()
            for (i in 0 until 4) {
                val nextX = currX + dx[i]
                val nextY = currY + dy[i]
                if (nextX in 0 until m && nextY in 0 until n && !visited[nextY][nextX] && maze[nextY][nextX] == '1') {
                    queue.add(nextY to nextX)
                    visited[nextY][nextX] = true
                    distances[nextY][nextX] = distances[currY][currX] + 1

                    if (nextY == n - 1 && nextX == m - 1) return distances[nextY][nextX]
                }
            }
        }

        return distances[n][m] // unreachable
    }

    println(bfs(0, 0))
}