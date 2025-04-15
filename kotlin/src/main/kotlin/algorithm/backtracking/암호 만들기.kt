package algorithm.backtracking

fun boj1759() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val l = nextToken().let { nval.toInt() }
    val c = nextToken().let { nval.toInt() }
    val chars = CharArray(c) {
        nextToken()
        sval.first()
    }
    chars.sort()
    val vowels = setOf('a', 'e', 'i', 'o', 'u')

    fun dfs(idx: Int, bucket: MutableList<Char>) {
        if (bucket.size == l) {
            val countVowel = bucket.count { it in vowels }
            if (countVowel > 0 && (l - countVowel) > 1) println(bucket.joinToString(""))
            return
        }

        for (i in idx  until c) {
            bucket.add(chars[i])
            dfs(i + 1, bucket)
            bucket.removeLast()
        }
    }

    dfs(0, mutableListOf())
}