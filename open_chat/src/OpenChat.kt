import java.util.*
class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        val ans = mutableListOf<String>()
        // 아이디, ent,leav
        val q = LinkedList<Pair<String,String>>()
        // 아이디,닉네임
        val nickMap = mutableMapOf<String,String>()
        for(str in record){
            if(str.split(" ").size == 3){
                val (cmd,id,nick) = str.split(" ")
                when(cmd){
                    "Enter"->{
                        // 큐에 넣고 닉네임도 변경해준다
                        q.add(Pair(id,cmd))
                        nickMap.put(id,nick)
                    }
                    "Change"->{
                        nickMap.put(id,nick)
                    }
                }
            }else{
                // leave
                val (cmd,id) = str.split(" ")
                q.add(Pair(id,cmd))
            }

        }
        // println(q)
        // println(nickMap)
        while(!q.isEmpty()){
            val po = q.poll()
            val nick = nickMap[po.first]
            if(po.second == "Enter") {
                ans.add(nick+"님이 들어왔습니다.")
            }else{
                ans.add(nick+"님이 나갔습니다.")
            }
        }
        return ans.toTypedArray()
    }
}