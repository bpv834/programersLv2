class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val typeMap = mutableMapOf<String,MutableList<String>>()
        for((name,type)in clothes){
            typeMap.getOrPut(type){mutableListOf()}.add(name)
        }
        var answer = 1
        typeMap.forEach{
            answer*=(typeMap[it.key]!!.size+1)
        }
        return answer-1
    }
}