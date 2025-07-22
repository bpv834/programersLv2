import java.util.*
class Solution {
    // 다시풀기
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val stack = Stack<Int>()
        var idx=0
        for(i in 1 .. order.size){
            stack.push(i)
            while(!stack.isEmpty()&&order[idx] == stack.peek()){
                idx++
                stack.pop()
                answer++
            }
        }
        return answer
    }
}