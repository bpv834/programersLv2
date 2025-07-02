import java.util.*
class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = IntArray(N)
        val pairList = mutableListOf<Pair<Int,Double>>()
        for(i in 1.. N){
            val fail:Double = if(getGte(i,stages) == 0.0) 0.0 else
                getE(i,stages)/getGte(i,stages)
            pairList.add(Pair(i,fail))
        }
        val sorted = pairList.sortedWith({a,b->
            if(a.second == b.second){
                a.first-b.first
            }else{
                if(b.second - a.second >0)  1 else -1
            }
        })
        for(i in 0 until N){
            answer[i] = sorted[i].first
        }
        return answer
    }
    fun getGte(n:Int,stages:IntArray):Double{
        var cnt = 0.0
        for(i in stages.indices){
            if(stages[i]>=n) cnt+=1
        }
        return cnt
    }

    fun getE(n:Int,stages:IntArray):Double{
        var cnt = 0.0
        for(i in stages.indices){
            if(stages[i]==n) cnt+=1
        }
        return cnt
    }
}