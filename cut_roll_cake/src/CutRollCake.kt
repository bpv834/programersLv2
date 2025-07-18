import java.util.*
class Solution {
    fun solution(topping: IntArray): Int {
        val record = mutableMapOf<Int,Int>()
        val topSet = mutableSetOf<Int>()
        var answer: Int = 0
        for(x in topping){
            record.put(x,record.getOrPut(x){0}+1)
        }

        for(x in topping){
            topSet.add(x)
            record[x] = record[x]!!-1

            if(record[x] == 0) {

                record.remove(x)

            }
            if(topSet.size == record.size) {
                answer++
            }
        }

        return answer
    }
}