package algorithm.bruteforcesearch

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `병합 후 포함되지 않는 가장 작은 자연수 naver-cloud-202504Test` {
    @Test
    fun testCase1() {
        val arr1 = intArrayOf(1, 3, 5)
        val arr2 = intArrayOf(2, 2, 6)
        val result = solution(arr1, arr2)
        assertEquals(1, result)
    }

    @Test
    fun testCase3() {
        val arr1 = intArrayOf(1, 4, 3)
        val arr2 = intArrayOf(2, 3, 6)
        val result = solution(arr1, arr2)
        assertEquals(1, result)
    }

    @Test
    fun testCase4() {
        val arr1 = intArrayOf(2, 2, 2)
        val arr2 = intArrayOf(2, 2, 2)
        val result = solution(arr1, arr2)
        assertEquals(1, result)
    }

    @Test
    fun testCase5() {
        val arr1 = intArrayOf(1, 4, 3)
        val arr2 = intArrayOf(2, 2, 4)
        val result = solution(arr1, arr2)
        assertEquals(1, result)
    }

    @Test
    fun test1() {
        val arr1 = intArrayOf(1, 2, 4, 3)
        val arr2 = intArrayOf(1, 3, 2, 3)
        val result = solution(arr1, arr2)
        assertEquals(2, result)
    }

    @Test
    fun test2() {
        val arr1 = intArrayOf(3, 2, 1, 6, 5)
        val arr2 = intArrayOf(4, 2, 1, 3, 3)
        val result = solution(arr1, arr2)
        assertEquals(3, result)
    }

    @Test
    fun test3() {
        val arr1 = intArrayOf(1, 2)
        val arr2 = intArrayOf(1, 2)
        val result = solution(arr1, arr2)
        assertEquals(3, result)
    }

    @Test
    fun test4() {
        val arr1 = intArrayOf(1)
        val arr2 = intArrayOf(1)
        val result = solution(arr1, arr2)
        assertEquals(2, result)
    }

    @Test
    fun test5() {
        val arr1 = intArrayOf(1, 2)
        val arr2 = intArrayOf(2, 3)
        val result = solution(arr1, arr2)
        assertEquals(1, result)
    }

    @Test
    fun test6() {
        val arr1 = intArrayOf(1, 5)
        val arr2 = intArrayOf(1, 7)
        val result = solution(arr1, arr2)
        assertEquals(2, result)
    }

    @Test
    fun test7() {
        val arr1 = intArrayOf(2, 3, 1, 5)
        val arr2 = intArrayOf(1, 4, 2, 6)
        val result = solution(arr1, arr2)
        assertEquals(1, result)
    }

    @Test
    fun test8() {
        val arr1 = intArrayOf(1, 2, 4)
        val arr2 = intArrayOf(1, 3, 4)
        val result = solution(arr1, arr2)
        assertEquals(2, result)
    }

    @Test
    fun test9() {
        val arr1 = intArrayOf(1, 2)
        val arr2 = intArrayOf(1, 2)
        val result = solution(arr1, arr2)
        assertEquals(3, result)
    }

    @Test
    fun test10() {
        val arr1 = intArrayOf(100000, 99999)
        val arr2 = intArrayOf(99998, 100000)
        val result = solution(arr1, arr2)
        assertEquals(1, result)
    }

    @Test
    fun test11() {
        val arr1 = intArrayOf(2, 3, 4, 5)
        val arr2 = intArrayOf(3, 4, 5, 6)
        val result = solution(arr1, arr2)
        assertEquals(1, result)
    }

    @Test
    fun test12() {
        val arr1 = intArrayOf(1, 2, 1)
        val arr2 = intArrayOf(1, 3, 1)
        val result = solution(arr1, arr2)
        assertEquals(2, result)
    }
}