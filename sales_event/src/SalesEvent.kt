class Solution {
    // 10일 회원권 판매
    // 회원은 제품을 하루 한개 싸게 구매 가능
    val wantMap = mutableMapOf<String,Int>()
    val recordMap = mutableMapOf<String,Int>()
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        for(i in number.indices){
            wantMap.put(want[i],number[i])
        }

        for(i in 0..9){
            val product = discount[i]
            recordMap.put(product, recordMap.getOrPut(product){0}+1)
        }
        if(isGood(want)) answer++
        var lt = 0
        for(rt in 10 until discount.size){
            val remove = discount[lt++]
            val add = discount[rt]
            recordMap.put(remove,recordMap.getOrPut(remove){0}-1)
            recordMap.put(add,recordMap.getOrPut(add){0}+1)
            if(isGood(want)) answer++
        }

        return answer

    }

    fun isGood(want: Array<String>):Boolean{
        want.forEach{
            if(wantMap[it]!= recordMap[it]) return false
        }



        return true
    }
}