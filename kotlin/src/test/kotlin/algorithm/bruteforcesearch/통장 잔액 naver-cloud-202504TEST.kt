package algorithm.bruteforcesearch

import kotlin.test.Test
import kotlin.test.assertEquals

class `통장 잔액 naver-cloud-202504TEST` {
    @Test
    fun test1() {
        val A = intArrayOf(100, 100, 100, -10)
        val D = arrayOf("2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29")

        val finalBalance = solution(A, D)
        assertEquals(230, finalBalance)
    }

    @Test
    fun test2() {
        val A = intArrayOf(180, -50, -25, -25)
        val D = arrayOf("2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31")

        val finalBalance = solution(A, D)
        assertEquals(25, finalBalance)
    }

    @Test
    fun test3() {
        val A = intArrayOf(1, -1, 0, -105, 1)
        val D = arrayOf("2020-12-31", "2020-04-04", "2020-04-04", "2020-04-14", "2020-07-12")

        val finalBalance = solution(A, D)
        assertEquals(-164, finalBalance)
    }

    @Test
    fun test4() {
        val A = intArrayOf(100, 100, -10, -20, -30)
        val D = arrayOf("2020-01-01", "2020-02-01", "2020-02-11", "2020-02-05", "2020-02-08")

        val finalBalance = solution(A, D)
        assertEquals(80, finalBalance)
    }

    @Test
    fun test5() {
        val A = intArrayOf(-60, 60, -40, -20)
        val D = arrayOf("2020-10-01", "2020-02-02", "2020-10-10", "2020-10-30")

        val finalBalance = solution(A, D)
        assertEquals(-115, finalBalance)
    }
}