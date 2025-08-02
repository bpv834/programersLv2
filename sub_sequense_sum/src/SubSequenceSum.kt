import java.util.*
class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        val q = LinkedList<Pair<Int,Int>>()
        var answer = IntArray(2)
        var sum =0
        var min = Int.MAX_VALUE
        for(i in sequence.indices){
            // println(sum)
            while(!q.isEmpty()&& sum + sequence[i] > k){
                val st = q.poll()
                sum-=st.first
            }
            q.add(Pair(sequence[i],i))
            sum+=sequence[i]

            if(sum == k && q.size < min){
                min = q.size
                val st = q.poll()
                //  println("st = $st")
                sum-=st.first
                answer[0]=st.second
                answer[1] =i
            }
        }
        return answer
    }
}