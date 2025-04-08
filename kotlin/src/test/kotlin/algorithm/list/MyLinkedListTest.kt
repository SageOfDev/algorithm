package algorithm.list

import kotlin.test.Test


fun <T> MyLinkedList<T>.insertWithPrint(position: Int, value: T) {
    insert(position, value)
    println(this)
}

fun <T> MyLinkedList<T>.eraseWithPrint(position: Int) {
    erase(position)
    println(this)
}

class MyLinkedListTest {

    @Test
    fun test() {
        val ll = MyLinkedList<Int>()
        ll.insertWithPrint(0, 1)
        ll.insertWithPrint(1, 2)
        ll.insertWithPrint(2, 3)
        ll.insertWithPrint(0, 4)
        ll.insertWithPrint(0, 5)
        ll.insertWithPrint(5, 6)
        ll.insertWithPrint(4, 7)
        ll.insertWithPrint(1, 8)
        ll.eraseWithPrint(4)
        ll.eraseWithPrint(0)
        ll.eraseWithPrint(5)
        ll.insertWithPrint(3, 9)
        ll.eraseWithPrint(1)
        ll.insertWithPrint(1, 10)
    }
}

