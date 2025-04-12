package algorithm.stack

const val LEGAL = "legal"
const val ILLEGAL = "illegal"

fun boj5076() {
    System.`in`.bufferedReader().use { br ->
        while (true) {
            val input = br.readLine()
            if (input == "#") break
            var answer = LEGAL

            var inTag = false
            val buffer = StringBuilder()
            val stk = ArrayDeque<String>()
            for (char in input) {
                when (char) {
                    '<' -> inTag = true
                    '>' -> {
                        if (inTag) {
                            val buffered = buffer.toString()
                            buffer.clear()
                            when {
                                buffered.endsWith('/') -> {
                                    // do nothing
                                }
                                buffered.startsWith('/') -> {
                                    if (stk.isEmpty()) {
                                        answer = ILLEGAL
                                        break
                                    }
                                    val last = stk.removeLast().split(' ').first()
                                    val curr = buffered.substring(1, buffered.length)
                                    if (last != curr) {
                                        answer = ILLEGAL
                                        break
                                    }
                                }
                                else -> {
                                    stk.addLast(buffered)
                                }
                            }
                            inTag = false
                        }
                    }
                    else -> {
                        if (inTag) buffer.append(char)
                    }
                }
            }

            if (stk.isNotEmpty()) answer = ILLEGAL
            println(answer)
        }
    }
}
