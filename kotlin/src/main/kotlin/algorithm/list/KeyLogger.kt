package algorithm.list

fun boj5397() {
    System.`in`.bufferedReader().use { br ->
        repeat(br.readLine().toInt()) {
            val keyLog = br.readLine()
            val left = mutableListOf<Char>()
            val right = mutableListOf<Char>()
            for (char in keyLog) {
                when (char) {
                    '<' -> if (left.isNotEmpty()) right.add(left.removeLast())
                    '>' -> if (right.isNotEmpty()) left.add(right.removeLast())
                    '-' -> if (left.isNotEmpty()) left.removeLast()
                    else -> left.add(char)
                }
            }
            val result = left + right.reversed()
            println(result.joinToString(""))
        }
    }
}