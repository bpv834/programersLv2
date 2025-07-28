import java.util.*
class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1 = LinkedList(queue1.toList())
        val q2 = LinkedList(queue2.toList())

        var sum1= q1.sumOf{it.toLong()}
        var sum2= q2.sumOf{it.toLong()}

        if((sum1+sum2)%2L != 0L) return -1
        val target = (sum1+sum2)/2

        val limit = (sum1+sum2)*2
        var cnt=0

        // limit를 구하는게 킥이다.
        // q1,과 q2가 전부 순환돼 원위치로 오는경우는 크기의 합 *2 이다.
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