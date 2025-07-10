class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        val map = mutableMapOf<Int,Int>()
        for(i in tangerine.indices){
            val cur  = tangerine[i]
            map.put(cur,map.getOrPut(cur){0}+1)
        }
        val list = map.toList().sortedWith({a,b->b.second-a.second})

        var sum=0
        var kind=0
        for(i in list.indices){
            if(sum+list[i].second>=k){
                kind++
                break
            }else{
                sum+=list[i].second
                kind++
            }
        }

        return kind
    }
}