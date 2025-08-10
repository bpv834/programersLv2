import java.util.*
class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        Arrays.sort(weights)
        val memo = IntArray(1001)
        memo[weights[0]] = 1
        val list = listOf(1.0, 2.0/3.0, 0.5, 0.75)

        for(i in 1 until weights.size){
            list.forEach{
                val mul = it*weights[i]
                // 값이 정수면
                if(mul == Math.floor(mul)&&memo[mul.toInt()]!=0){
                    answer += memo[mul.toInt()]
                }
            }
            memo[weights[i]] = memo[weights[i]]+1
        }
        return answer
    }
}