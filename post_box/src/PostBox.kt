fun solution(order: IntArray): Int {
    val stack = ArrayDeque<Int>()
    var box = 1
    var count = 0

    for (target in order) {
        while (box <= order.size && (stack.isEmpty() || stack.last() != target)) {
            stack.add(box)
            box++
        }

        if (stack.last() == target) {
            stack.removeLast()
            count++
        } else {
            break
        }
    }

    return count
}
