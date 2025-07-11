class Solution {
    fun solution(n: Int): Long {
        val mod = 1234567
        if(n == 1) return 1L
        if(n == 2) return 2L
        val arr = LongArray(n+1)
        arr[0]=0
        arr[1]=1
        arr[2]=2
        for(i in 3..n){
            arr[i] = (arr[i-2] + arr[i-1])%mod
        }
        return arr[n]
    }
}