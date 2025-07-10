class Solution {
    fun solution(n: Int): Int {
        val arr = IntArray(100001)
        val mod = 1234567
        arr[0]=0
        arr[1]=1
        for(i in 2..100000){
            arr[i] = (arr[i-2]+arr[i-1])%mod
        }
        return arr[n]
    }


}