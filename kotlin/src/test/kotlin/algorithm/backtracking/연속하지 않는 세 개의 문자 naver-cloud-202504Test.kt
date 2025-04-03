package algorithm.backtracking

import algorithm.backtracking.generateHighestString
import kotlin.test.Test
import kotlin.test.assertEquals

class `연속하지 않는 세 개의 문자 naver-cloud-202504Test` {
    @Test
    fun testSingleEach() {
        // 각 알파벳 1개씩: a=1, b=1, c=1 일 때, 사전순 우선순위에 따라 "cba"가 기대 결과입니다.
        val result = generateHighestString(1, 1, 1)
        assertEquals("abc", result)
    }

    @Test
    fun testSimpleCase() {
        // 예시: a=2, b=2, c=1
        // 시뮬레이션 결과: "cbbaa"가 기대 결과입니다.
        val result = generateHighestString(2, 2, 1)
        assertEquals("aabbc", result)
    }

    @Test
    fun testImpossibleCase() {
        // 예시: a=3, b=0, c=0 인 경우 "aaa"가 되어 연속 3개 조건을 위배하므로 해가 없으며,
        // 빈 문자열("")을 반환해야 합니다.
        val result = generateHighestString(3, 0, 0)
        assertEquals("", result)
    }

    @Test
    fun testEdgeCase() {
        // 모든 알파벳의 개수가 0인 경우 빈 문자열이 반환되어야 합니다.
        val result = generateHighestString(0, 0, 0)
        assertEquals("", result)
    }

    @Test
    fun testLargeCounts() {
        val a = 5
        val b = 3
        val c = 3
        val result = generateHighestString(a, b, c)
        assertEquals("aabaabacbcc", result)
    }
}