import java.util.*
class Solution {
    fun solution(numbers: IntArray): IntArray {
        val res = IntArray(numbers.size){-1}
        val stack = Stack<Pair<Int,Int>>()
        for(i in 0 until numbers.size){
            val cur = numbers[i]
            while(!stack.isEmpty() && cur>stack.peek().first){
                val pre = stack.pop()
                res[pre.second] = cur
            }
            stack.push(Pair(cur,i))
        }

        return res
    }
}