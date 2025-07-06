class Solution {
    fun solution(s: String): String {
        var answer = ""
        val list = s.split(" ").map{it.toInt()}.sorted()
        val sb =StringBuilder()
        sb.append("${list.first()} ${list.last()}")
        return sb.toString()
    }
}