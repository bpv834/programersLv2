import java.util.*
class Solution {
    lateinit var graph : Array<MutableList<Int>>
    lateinit var visits : BooleanArray
    lateinit var q : Queue<Int>
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = 100
        q = LinkedList<Int>()
        for(i in wires.indices){
            graph = Array(n+1){mutableListOf()}
            visits = BooleanArray(n+1)
            for(j in wires.indices){
                if(j==i) continue
                val st = wires[j][0]
                val end = wires[j][1]
                graph[st].add(end)
                graph[end].add(st)
            }
            val lGraph = bfs(1)
            val rGraph = n-lGraph
            answer = Math.min(answer,Math.abs(lGraph-rGraph))
        }
        return answer
    }

    fun bfs(vtx : Int):Int{
        var count = 0
        q.add(vtx)
        visits[vtx]=true
        while(!q.isEmpty()){
            val nv = q.poll()
            //    println(nv)
            count++
            for(v in graph[nv]){
                if(!visits[v]) {
                    q.add(v)
                    visits[v]=true
                }
            }
        }
        // println("count = $count")
        return count
    }
}
