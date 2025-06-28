class Solution {
    fun solution(citations: IntArray): Int {
        var answer = citations.size
        val sorted = citations.toList().sortedDescending()

        for(i in sorted.indices){
            val h = i+1
            if(sorted[i]<h) {
                answer = i
                break
            }
        }

        return answer
    }
}