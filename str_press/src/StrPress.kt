
class Solution {
    fun solution(s: String): Int {
        var answer = 1001

        for(i in 1 .. s.length){
            answer = Math.min(answer,getLen(s,i))
        }

        return answer
    }
}


fun getLen(s : String, press : Int): Int{
    val len = s.length
    val left = len%press
    val lenA = len/press * press - press
    var dropCnt =len/press * press
    val sb =StringBuilder()

    var subStr = s.substring(0,press)
    var cnt=1
    // println("$s = s")
    // println("len : $len left : $left lenA : $lenA dropCnt :$dropCnt sub: $subStr" )

    for(i in press .. lenA step press){
        val string = s.substring(i,i+press)
        // println("string : $string")
        if(subStr==string){
            cnt++
        }else{
            if(cnt>1) sb.append(cnt)
            sb.append(subStr)
            cnt=1
            subStr = string
        }
    }
    if(cnt>1) sb.append(cnt)
    sb.append(subStr)

    sb.append(s.drop(dropCnt))
    // println(sb)

    return sb.length

}

fun main() {
    val s = Solution()
    println(s.solution("abcabcabcabcdededededede"))
}