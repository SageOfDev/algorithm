package algorithm.dfs

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    repeat(i()) {
        val n = i()
        val pick = IntArray(n + 1).apply { for (i in 1 .. n) this[i] = i() }.apply { this[0] = 0}
        val visited = BooleanArray(n + 1).apply { for (i in 1 .. n) this[i] = false }.apply { this[0] = true }

        var answer = 0
        fun dfs(curr: Int, bucket: MutableList<Int>) { // cyclic 을 찾을 때까지 dfs 로 순회
            if (visited[curr]) return

            visited[curr] = true
            bucket.add(curr)

            val next = pick[curr]
            if (visited[next]) {
                val idx = bucket.indexOf(next)
                if (idx == -1) {
                    answer += bucket.size // 다음 노드가 이미 방문했는데 이번 순회에 담겨 있지 않았다면, 이미 cycle 을 찾은 것. 이번 순회의 노드들으 모두 cycle 을 이루지 않음
                    return
                } else {
                    answer += idx // 다음 노드가 이미 방문했고, 이번 순회에 담겨 있다면, 다음 노드부터 현재 노드까지 cycle 이고 나머지가 non cyclic 노드
                    return
                }
            } else dfs(next, bucket)
        }

        for (i in 1 .. n) {
            if (!visited[i]) dfs(i, mutableListOf())
        }

        println(answer)
    }
}