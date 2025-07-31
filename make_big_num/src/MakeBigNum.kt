import java.util.*
class Solution {
    fun solution(number: String, k: Int): String {
        val chs = number.toCharArray()
        val stack = Stack<Pair<Int,Int>>()
        var cnt=0

        for(i in number.indices){
            while(!stack.isEmpty() &&stack.peek().first < number[i].toInt()-48){
                val pop = stack.pop()
                chs[pop.second] = '-'
                cnt++
                if(cnt == k) break
            }
            if(cnt == k) break
            stack.push(number[i].toInt()-48 to i)
        }
        val result = chs.joinToString("").replace("-","")
        val left = k-cnt
        if(cnt != k) return result.substring(0,result.length-left)
        return result

    }
}