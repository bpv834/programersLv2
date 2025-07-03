import java.util.*
class Solution {
    lateinit var answer : Array<String>
    val map = mutableMapOf<String,PriorityQueue<String>>()
    fun solution(tickets: Array<Array<String>>): Array<String> {
        answer = Array<String>(tickets.size+1){"ICN"}

        for((st,ar) in tickets){
            map.getOrPut(st){
                PriorityQueue<String>({a,b->a.compareTo(b)})
            }.add(ar)
        }
        dfs(0,"ICN")

        return answer
    }

    fun dfs(dep:Int, str:String){
        if(str.isNullOrEmpty()) return
        else{
            answer[dep] = str
            dfs(dep+1,map[str]!!.poll()?:"")

        }

    }
}