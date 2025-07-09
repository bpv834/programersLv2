class Solution {
    // 제거한 0 개수
    var sum = 0
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var initS = s
        var tryCnt =0
        while(initS!="1"){
            tryCnt++
            initS = setBin(initS)
        }
        answer = intArrayOf(tryCnt,sum)

        return answer
    }
    fun setBin(str : String):String{
        // 0을 제거
        // 제거한 문자열 길이를 2진법으로 표현한 문자열로 변경

        // 0개수
        val zero = countZero(str)
        sum+=zero
        val removeZeroLen = str.replace("0","").length
        return removeZeroLen.toString(2)
    }

    fun countZero(str : String) : Int{
        var cnt = 0
        for(i in str.indices){
            if(str[i] == '0') cnt++
        }
        return cnt
    }
}