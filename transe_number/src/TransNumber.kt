import java.util.*
class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        val q = LinkedList<Pair<Int,Int>>()
        val ch = IntArray(1000001){0}

        var answer: Int = -1
        q.add(Pair(x,0))
        while(!q.isEmpty()){
            val p = q.poll()
            if(p.first == y) return p.second
            if(p.first*2 <=y&&ch[p.first*2]==0) {q.add(Pair(p.first*2,p.second+1))
                ch[p.first*2]=1
            }
            if(p.first*3 <=y&&ch[p.first*3]==0){q.add(Pair(p.first*3,p.second+1))
                ch[p.first*3]=1
            }
            if(p.first+n <=y&&ch[p.first+n]==0) {q.add(Pair(p.first+n,p.second+1))
                ch[p.first+n]=1}
        }
        return answer
    }
}