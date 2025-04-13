package algorithm.queue

fun boj3078() {
    val br = System.`in`.bufferedReader()
    val st = java.util.StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val rankToLength = Array(n + 1) { 0 } // use 1 to n
    val lengthToGf = Array(21) { 0 } // use 1 to 20
    var answer = 0L

    for (rank in 1 .. n) {
        val currLength = br.readLine().length
        rankToLength[rank] = currLength
        if (rank > k) {
            lengthToGf[rankToLength[rank - k - 1]] -= 1 // k 등수 이상 차이 나면 dequeue
        }
        answer += lengthToGf[currLength]
        lengthToGf[currLength] += 1 // enqueue
    }

    println(answer)
}