package algorithm.list

class ListNode<T> {
    var value: T
    var next: ListNode<T>? = null

    constructor(value: T) {
        this.value = value
    }

    constructor(value: T, next: ListNode<T>?) {
        this.value = value
        this.next = next
    }
}

class MyLinkedList<T> {
    var head: ListNode<T>? = null
        private set
    var tail: ListNode<T>? = null
        private set
    var size = 0
        private set

    fun insert(position: Int, value: T) {
        if (position < 0 || position > size) {
            throw IndexOutOfBoundsException("Index: $position, Size: $size")
        }


        if (position == 0) {
            head = ListNode(value, head)
            if (size == 0) {
                tail = head
            }
        } else if (position == size) {
            tail?.next = ListNode(value)
            tail = tail?.next
        } else {
            var current = head
            for (i in 0 until position - 1) {
                current = current?.next
            }
            val newNode = ListNode(value, current?.next)
            current?.next = newNode
            if (newNode.next == null) {
                tail = newNode
            }
        }
        size++
    }

    fun erase(position: Int) {
        if (position < 0 || position >= size) {
            throw IndexOutOfBoundsException("Index: $position, Size: $size")
        }

        if (position == 0) {
            head = head?.next
            if (size == 1) {
                tail = null
            }
        }  else {
            var current = head
            for (i in 0 until position - 1) {
                current = current?.next
            }
            current?.next = current?.next?.next
            if (current?.next == null) {
                tail = current
            }
        }
        size--
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var current = head
        while (current != null) {
            sb.append(current.value).append(" -> ")
            current = current.next
        }
        sb.append("null")
        return sb.toString()
    }
}
