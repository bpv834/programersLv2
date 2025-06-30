class Solution {
    lateinit var visits : BooleanArray
    var max =0
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visits = BooleanArray(dungeons.size)
        dfs(0,0,k,dungeons)
        return max
    }
    fun dfs(dep:Int, cnt:Int, current:Int,dungeons : Array<IntArray>){
        if(dep == dungeons.size){
            max = Math.max(max,cnt)
        }else{
            for(i in dungeons.indices){
                if(!visits[i]){
                    visits[i]=true
                    val needs = dungeons[i][0]
                    val consume = dungeons[i][1]
                    if(current>=needs){
                        dfs(dep+1,cnt+1,current-consume,dungeons)
                        visits[i]=false
                    }else{
                        dfs(dep+1,cnt,current,dungeons)
                        visits[i]=false
                    }

                }
            }
        }
    }
}