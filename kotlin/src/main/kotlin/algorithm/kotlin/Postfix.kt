package algorithm.kotlin

import java.util.*

fun infixToPostfix() {
    System.`in`.bufferedReader().use { br ->
        val stk = Stack<Char>()
        var answer = StringBuilder()
        br.readLine().forEach { ch ->
            when {
                ch.isLetter() -> answer.append(ch)
                ch == '(' -> stk.push(ch)
                ch == ')' -> {
                    while (stk.isNotEmpty() && stk.peek() != '(') {
                        answer.append(stk.pop())
                    }
                    if (stk.isNotEmpty() && stk.peek() == '(') {
                        stk.pop()
                    }
                }
                else -> {
                    if (ch == '-' || ch ==  '+') {
                        while (stk.isNotEmpty() && stk.peek() != '(') {
                            answer.append(stk.pop())
                        }
                    }
                    else {
                        while (stk.isNotEmpty() && stk.peek() != '(' && stk.peek() != '-' && stk.peek() != '+') {
                            answer.append(stk.pop())
                        }
                    }
                    stk.push(ch)
                }
            }
        }
        while (stk.isNotEmpty()) {
            answer.append(stk.pop())
        }
        println(answer.toString())
    }
}

fun operatePostfix() {
    System.`in`.bufferedReader().use { br ->
        val n = br.readLine().toInt()
        val postfix = br.readLine()
        val value: MutableMap<Char, Int> = mutableMapOf()
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        for (i in 0 until n) {
            value[alphabet[i]] = br.readLine().toInt()
        }

        val operand = Stack<Double>()
        for (x in postfix) {
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
        println("${String.format("%.2f", operand.pop())}")
    }
}