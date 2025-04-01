package algorithm.stack

import kotlin.test.Test
import kotlin.test.assertEquals

class PostfixKtTest {

    @Test
    fun testPostfix() {
        infixToPostfix("a+b").also {
            assertEquals("ab+", it)
        }
    }

    @Test
    fun testPostfixOperation() {

        operatePostfix("ABC*+DE/-", listOf(1, 2, 3, 4, 5)).also {
            println(it)
        }
    }

}