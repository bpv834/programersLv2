class Solution {
    val dy = intArrayOf(1,0,-1)
    val dx = intArrayOf(0,1,-1)
    fun solution(n: Int): IntArray {
        val tri = n*(n+1)/2
        val answer = IntArray(tri)
        val map = Array(n){IntArray(n)}

        var cnt =0
        var dir = 0
        var y=0
        var x=0
        var num =1
        while(cnt<tri){
            map[y][x] = num++
            cnt++
            if(!(y+dy[dir] in 0..n-1 && x+dx[dir] in 0..n-1&& map[y+dy[dir]][x+dx[dir]] == 0)) dir=(dir+1)%3

            y=y+dy[dir]
            x=x+dx[dir]
        }
        var idx =0
        for(i in 0..n-1){
            for(j in 0 .. n-1){
                if(map[i][j]!=0) answer[idx++] = map[i][j]
            }
        }
        return answer
    }
}