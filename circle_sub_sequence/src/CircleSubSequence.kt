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

    fun solution2(elements: IntArray): Int {
        var answer: Int = 0
        val mySet = mutableSetOf<Int>()
        val expand = elements + elements
        val prefix = IntArray(expand.size + 1)
        for(i in 1 .. expand.size){
            prefix[i] = prefix[i-1] + expand[i-1]
        }
        println(prefix.joinToString())
        for(i in 1 .. elements.size){
            for(j in i until i+elements.size){
                val x = prefix[j]-prefix[i-1]
                mySet.add(x)
            }
        }
        return mySet.size
    }
}
