import java.util.*
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val idxWithList = priorities.withIndex()
        val q = LinkedList<Pair<Int,Int>>()
        idxWithList.forEach{
            q.add(Pair(it.index, it.value))
        }

        return getResult(q,location)
    }
    fun getResult(q : LinkedList<Pair<Int,Int>>, location : Int):Int{
        var result = 0


        while(!q.isEmpty()){
            val p = q.poll()
            val pq = PriorityQueue<Pair<Int,Int>>(){ a, b -> b.second - a.second }
            // 2개가 남았었고 한개를 원하는 인덱스가 아니라 폴하고 결국 한개만 남는 상황이 생김
            // 그땐 폴하면 q 사이즈가 0이 된다. 그래서 addAll을 할 q가 없기때문에 뽑았던 p를 넣는다 어차피 크거나 같기만 하면 되니까
            if(q.size ==0) pq.add(p) else pq.addAll(q)
            if (p.second >=pq.peek().second){
                result++
                if(p.first == location) return result
            }else{
                q.add(p)
            }
        }
        return result
    }
}

fun main() {
    val so = Solution()
    println(so.solution(intArrayOf(1, 1, 9, 1, 1, 1),0))
}