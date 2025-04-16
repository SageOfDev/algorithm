package algorithm.dynamicprogramming

private
class Solution {
    fun solution(n: Int): Long {
        var answer: Long = 0
        var a = 0L
        var b = 1L

        for (i in 0 until n - 1) {
            val temp = a + b
            a = b
            b = temp
        }

        answer = b
        return answer
    }
}
