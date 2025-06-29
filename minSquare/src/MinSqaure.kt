class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var maxW =0
        var maxH =0
        sizes.forEach{
            it.sortDescending()
            maxW = Math.max(maxW,it[0])
            maxH = Math.max(maxH,it[1])
        }
        return maxW*maxH
    }
}