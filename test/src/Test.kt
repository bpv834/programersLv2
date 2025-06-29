class Solution {
    fun solution(answers: IntArray): IntArray {
        val result = IntArray(3)
        val r1 = intArrayOf(1,2,3,4,5)
        val r2 = intArrayOf(2,1,2,3,2,4,2,5)
        val r3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)

        for(i in answers.indices){
            if(answers[i]== r1[i%5]) result[0] = result[0]+1
            if(answers[i]== r2[i%8]) result[1] = result[1]+1
            if(answers[i]== r3[i%10]) result[2] = result[2]+1
        }
        println(result.joinToString())
        val maxScore = result.toList().sortedDescending()[0]
        var answer = mutableListOf<Int>()
        for(i in result.indices){
            if(result[i]== maxScore) answer.add(i+1)
        }
        return answer.toIntArray()
    }
}