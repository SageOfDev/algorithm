package algorithm.greedy

/**
 * 윈도우 크키가 W와 숫자들의 스트림 S 가 주어졌을 때, 스트림 S에서 새로운 숫자를 받을 때마다 슬라이딩 윈도우 내에서 최대값을 출력하는 문제를 kotlin 으로 풀어달라. 또한 알고리즘의 복잡성을 설명해달라.

윈도우 크기 W 는 0 < W  <= 300,000,000 범위의 정수이다.
입력되는 스트림 숫자들의 범위는 -3,000,000,000 <=  S 의 원소들 <= 3,000,000,000의 정수이다.

예시
윈도우 W=2, 스트림 S = [2, 1, 2, -1 ,3]일때, 첫 째 줄에 W 다음줄부터 스트림원소가 한 줄에 하나씩 입력됨
입력
2
2
1
2
-1
3

출력
2
2
2
3

완성시켜야할 kotlin 코드
fun main(args: Array<String>) {
}
*/

//fun slidingWindowMax(args: Array<String>) {
fun main(args: Array<String>) {
    System.`in`.bufferedReader().use { br ->
        val w = br.readLine()?.trim()?.toIntOrNull() ?: return

        val deque = ArrayDeque<Pair<Int, Long>>() // (idx, num) 에 대하여 num 으로는 내림차순, idx 에 대하여 오름차순
        var idx = 0

        while (true) {
            val line = br.readLine() ?: break
            if (line.trim().isEmpty()) continue

            val num = line.trim().toLongOrNull() ?: continue

            while (deque.isNotEmpty() && deque.last().second <= num) {
                deque.removeLast()
            }
            deque.addLast(Pair(idx, num))

            // 슬라이딩 윈도우 범위에서 벗어난 인덱스이면 덱의 앞쪽 원소 제거
            while (deque.isNotEmpty() && deque.first().first <= idx - w) {
                deque.removeFirst()
            }

            // 윈도우 크기만큼 채워졌다면 최대값 출력 (덱의 첫 번째 원소)
            if (idx >= w - 1) {
                println(deque.first().second)
            }

            idx++
        }
    }
}
