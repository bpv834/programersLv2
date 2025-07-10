class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 0
        var ans = 1
        for(i in arr.indices){
            ans = getLcm(ans,arr[i])
        }
        return ans
    }
    fun getGcd(a:Int,b:Int):Int{
        if(b==0) return a
        return getGcd(b,a%b)
    }
    fun getLcm(a:Int,b:Int):Int{
        val gcd = getGcd(a,b)
        return a*b/gcd
    }
}