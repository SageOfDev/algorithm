package algorithm.bruteforcesearch

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class `병합 후 포함되지 않는 가장 작은 자연수 naver-cloud-202504Test` {
    @Test
    fun testCase1() {
        val arr1 = intArrayOf(1, 3, 5)
        val arr2 = intArrayOf(2, 2, 6)
        val result = smallestMissingPositive(arr1, arr2)
        println("Test Case 1: result = $result")
        assertEquals(3, result)
    }

    @Test
    fun testCase3() {
        val arr1 = intArrayOf(1, 4, 3)
        val arr2 = intArrayOf(2, 5, 6)
        val result = smallestMissingPositive(arr1, arr2)
        println("Test Case 3: result = $result")
        assertEquals(2, result)
    }

    @Test
    fun testCase4() {
        val arr1 = intArrayOf(2, 2, 2)
        val arr2 = intArrayOf(2, 2, 2)
        val result = smallestMissingPositive(arr1, arr2)
        println("Test Case 4: result = $result")
        assertEquals(1, result)
    }

    @Test
    fun testCase5() {
        val arr1 = intArrayOf(1, 4, 3)
        val arr2 = intArrayOf(2, 2, 4)
        val result = smallestMissingPositive(arr1, arr2)
        println("Test Case 5: result = $result")
        assertEquals(4, result)
    }
}