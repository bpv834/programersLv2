class Solution {
    fun solution(elements: IntArray): Int {
        val n = elements.size
        val extended = elements + elements
        val prefixSum = IntArray(2 * n + 1) // 누적합 계산용

        for (i in 1..2 * n) {
            prefixSum[i] = prefixSum[i - 1] + extended[i - 1]
        }

        val sumSet = mutableSetOf<Int>()

        for (length in 1..n) {
            for (start in 0 until n) {
                val sum = prefixSum[start + length] - prefixSum[start]
                sumSet.add(sum)
            }
        }

        return sumSet.size
    }
}
