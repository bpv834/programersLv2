import java.util.*
class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        var max = 0
        val ch = IntArray(1500)
        val sort = book_time.sortedWith({
                a,b-> transeMinuete(a[0]) - transeMinuete(b[0])
        })

        sort.forEach{
            val stM = transeMinuete(it[0])
            val endM = transeMinuete(it[1])+9 // 10분간 청소

            for(i in stM .. endM){
                ch[i] = ch[i]+1
                max = Math.max(ch[i],max)

            }
        }
        //println(Arrays.toString(ch))

        return max
    }

    // 문자열 hh:mm 을 분으로 바꾸는 메서드
    fun transeMinuete(time : String):Int{
        val (hour, minute) = time.split(":").map{it.toInt()}
        return hour *60 + minute
    }

}