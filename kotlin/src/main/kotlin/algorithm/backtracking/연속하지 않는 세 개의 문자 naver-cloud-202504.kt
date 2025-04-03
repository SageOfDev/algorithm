package algorithm.backtracking

/**
 * a, b, c 세 가지의 알파벳의 개수가 입력으로 주어진다. 주어진 모든 알파벳을 다 사용해서 문자열을 완성하라. 단, 다음의 조건을 만족해야한다.
 * 1. 같은 문자가 연속해서 세 번 위치할 수 없다.
 * 2. 1.을 만족하는 문자열 중 lexico-graphical 우선 순위가 가장 높아야 한다.
 *
 * greedy 로 풀면 a:5, b:3, c:3 을 풀지 못함. aabaabab 에서 실패. 백트래킹이 있으면 aabaabab 가 틀리고 aabaabac 로 넘어감
 */
fun solution(A: Int, B: Int, C: Int): String {
    val result = dfs(A, B, C, StringBuilder())
    return result ?: ""
}

private fun dfs(a: Int, b: Int, c: Int, sb: StringBuilder): String? {
    // 모든 알파벳을 사용했다면 해를 찾은 것임
    if (a == 0 && b == 0 && c == 0) return sb.toString()

    // 가지치기: 남은 총 개수와 그 중 최대 개수를 비교하여,
    // 한 문자(count = maxCount)가 남은 다른 문자들의 수보다 너무 많으면 남은 문자들을
    // 연속 3개 없이 배치하는 것이 불가능함.
    val total = a + b + c
    val maxCount = maxOf(a, b, c)
    if (maxCount > 2 * ((total - maxCount) + 1)) return null

    // 사전순으로 낮은 순서: 'a' → 'b' → 'c'
    for (letter in listOf('a', 'b', 'c')) {
        when (letter) {
            'a' -> {
                if (a <= 0) continue
                if (sb.length >= 2 && sb[sb.length - 1] == 'a' && sb[sb.length - 2] == 'a') continue
                sb.append('a')
                val res = dfs(a - 1, b, c, sb)
                if (res != null) return res
                sb.deleteCharAt(sb.length - 1)
            }
            'b' -> {
                if (b <= 0) continue
                if (sb.length >= 2 && sb[sb.length - 1] == 'b' && sb[sb.length - 2] == 'b') continue
                sb.append('b')
                val res = dfs(a, b - 1, c, sb)
                if (res != null) return res
                sb.deleteCharAt(sb.length - 1)
            }
            'c' -> {
                if (c <= 0) continue
                if (sb.length >= 2 && sb[sb.length - 1] == 'c' && sb[sb.length - 2] == 'c') continue
                sb.append('c')
                val res = dfs(a, b, c - 1, sb)
                if (res != null) return res
                sb.deleteCharAt(sb.length - 1)
            }
        }
    }
    return null
}
