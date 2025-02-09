package algorithm.kotlin

import java.util.*

fun boj1918() {
    System.`in`.bufferedReader().use { br ->
        val infixNotation = br.readLine()
        val answer = infixToPostfix(infixNotation)
        println(answer)
    }
}

fun infixToPostfix(infixNotation: String): String {
    val postfixNotation = StringBuilder()
    val operatorStk = Stack<Char>()
    val priority = mapOf('+' to 1, '-' to 1, '*' to 2, '/' to 2) // '(' 제외

    infixNotation.forEach { ch ->
        when {
            ch.isLetterOrDigit() -> postfixNotation.append(ch) // 피연산자 처리
            ch == '(' -> operatorStk.push(ch) // 여는 괄호는 스택에 무조건 push
            ch == ')' -> {
                // 닫는 괄호는 여는 괄호가 나올 때까지 연산자를 pop
                while (operatorStk.isNotEmpty() && operatorStk.peek() != '(') {
                    postfixNotation.append(operatorStk.pop())
                }
                if (operatorStk.isEmpty() || operatorStk.pop() != '(') {
                    throw IllegalArgumentException("Mismatched parentheses in input expression")
                }
            }
            ch in priority -> {
                // 현재 연산자와 스택의 top 연산자 우선순위 비교
                while (operatorStk.isNotEmpty() && operatorStk.peek() != '(' &&
                    priority[operatorStk.peek()]!! >= priority[ch]!!
                ) {
                    postfixNotation.append(operatorStk.pop())
                }
                operatorStk.push(ch)
            }
            else -> throw IllegalArgumentException("Invalid character in input expression: $ch")
        }
    }

    // 남은 연산자를 postfixNotation에 추가
    while (operatorStk.isNotEmpty()) {
        val top = operatorStk.pop()
        if (top == '(') throw IllegalArgumentException("Mismatched parentheses in input expression")
        postfixNotation.append(top)
    }

    return postfixNotation.toString()
}

fun boj1935() {
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()
        val postfixNotation = br.readLine()
        val intList = mutableListOf<Int>()
        for (i in 0 until n) {
            intList.add(br.readLine().toInt())
        }

        val answer = operatePostfix(postfixNotation, intList)
        println(answer)
    }
}

fun operatePostfix(postfixNotation: String, numbers: List<Int>): String {
    val value: MutableMap<Char, Int> = mutableMapOf()
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    for (i in numbers.indices) {
        value[alphabet[i]] = numbers[i]
    }

    val operand = Stack<Double>()
    for (x in postfixNotation) {
        when (x) {
            '+' -> {
                val tempB = operand.pop()
                val tempA = operand.pop()
                operand.push(tempA+tempB)
            }
            '-' -> {
                val tempB = operand.pop()
                val tempA = operand.pop()
                operand.push(tempA-tempB)
            }
            '*' -> {
                val tempB = operand.pop()
                val tempA = operand.pop()
                operand.push(tempA*tempB)
            }
            '/' -> {
                val tempB = operand.pop()
                val tempA = operand.pop()
                operand.push(tempA/tempB)
            }
            else -> {
                operand.push(value[x]!!.toDouble())
            }
        }
    }

    return String.format("%.2f", operand.pop())
}
