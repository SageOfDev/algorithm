package algorithm.bfs


fun boj1327() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val n = i()
    val k = i()
    val initState = MutableList(n) { i() }.joinToString("")
    val targetState = (1..n).joinToString("")

    // BFS를 위한 큐와 방문 처리 집합
    val queue: ArrayDeque<Pair<String, Int>> = ArrayDeque()
    val visited = mutableSetOf<String>()
    queue.add(Pair(initState, 0))
    visited.add(initState)

    // BFS 진행
    while (queue.isNotEmpty()) {
        val (state, moves) = queue.removeFirst()
        // 목표 상태에 도달하면 moves를 출력하고 종료
        if (state == targetState) {
            println(moves)
            return
        }
        // 가능한 뒤집기 연산 적용:
        // 상태 문자열의 길이는 n이며, 연속 k개를 뒤집기 때문에,
        // 인덱스 i = 0부터 i = n - k 까지 가능.
        for (i in 0..n - k) {
            // i번째부터 k개 구간 뒤집기
            val newState = state.substring(0, i) + state.substring(i, i + k).reversed() + state.substring(i + k)
            if (newState !in visited) {
                visited.add(newState)
                queue.add(Pair(newState, moves + 1))
            }
        }
    }
    // 목표 상태에 도달할 수 없는 경우 -1 출력
    println(-1)
}
