class Solution {
    fun solution(numbers: LongArray): LongArray {
        var answer = LongArray(numbers.size)
        for(i in numbers.indices){
            answer[i] = getRes(numbers[i])
        }
        return answer
    }
    fun getRes(num : Long) : Long{
        if(num%2L==0L) return num+1
        else{
            val bin = ("0"+num.toString(2)).toCharArray()
            for(i in bin.size-1 downTo 0){
                if(bin[i] == '0'){
                    bin[i] ='1'
                    bin[i+1] = '0'
                    break
                }
            }
            return bin.joinToString("").toLong(2)
        }
    }
}