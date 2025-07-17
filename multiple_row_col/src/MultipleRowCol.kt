class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        var N = arr1.size
        var M = arr1[0].size
        var K = arr2[0].size
        var res = Array<IntArray>(N){IntArray(K)}

        for(i in 0 .. N-1){
            for(k in 0 ..K-1){
                var sum =0
                for(j in 0 .. M-1){
                    sum += arr1[i][j] * arr2[j][k]
                }
                res[i][k] = sum
            }
        }
        return res
    }
}