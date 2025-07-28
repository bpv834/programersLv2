import java.util.*
class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1 = LinkedList(queue1.toList())
        val q2 = LinkedList(queue2.toList())

        var sum1= q1.sumOf{it.toLong()}
        var sum2= q2.sumOf{it.toLong()}

        if((sum1+sum2)%2L != 0L) return -1
        val target = (sum1+sum2)/2

        val limit = (q1.size)*3 // 두 큐의 크기가 같다면 *2는 서로 자리를 바꾼거 나머지 한번은 자리를 바꾸고 한쪽으로 전부 옮긴경우
        // 1234
        // 5678

        // 56781234 ( size*3 )횟수//

        var cnt=0

        while(cnt<=limit){
            //  println("cnt=$cnt / sum1 = $sum1 / q1 = $q1 / sum2 = $sum2 / q2= $q2")
            if(sum1<target){
                val num = q2.poll()
                sum1+=num
                sum2-=num
                q1.add(num)
            }else if(sum1>target){
                val num = q1.poll()
                sum1-=num
                sum2+=num
                q2.add(num)
            }else{
                return cnt
            }
            cnt++
        }
        return -1
    }
}