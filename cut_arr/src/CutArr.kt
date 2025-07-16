class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = IntArray((right - left + 1).toInt())
        for (i in left..right) {
            val row = (i / n).toInt()
            val col = (i % n).toInt()
            answer[(i - left).toInt()] = maxOf(row, col) + 1
        }
        return answer
    }
}