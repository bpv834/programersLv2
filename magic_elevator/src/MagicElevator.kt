class Solution {
    var minCnt = Int.MAX_VALUE
    fun solution(storey: Int): Int {
        var answer: Int = 0
        dfs(storey,0)
        return minCnt
    }
    fun dfs(num : Int , cnt : Int){
        if(num == 0){
            minCnt = Math.min(minCnt,cnt)
        }
        if(cnt >= minCnt) return

        val end = num%10
        val new = num/10

        // 내림
        dfs(new, cnt+end)
        // 올림
        dfs(new+1,cnt+10-end)
    }
}