import java.util.*
class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val sb = StringBuilder()
        sb.append(s)
        if(isCorrect(sb.toString())) answer++
        for(i in 1 .. s.length-1){
            val delete = sb[0]
            sb.deleteCharAt(0)
            println("delete= $delete")
            sb.append(delete)

            if(isCorrect(sb.toString())) answer++
        }
        return answer
    }
    fun isCorrect(str:String): Boolean{
        val stack = Stack<Char>()
        for(ch in str){
            if(stack.isEmpty()&& (ch == ')' || ch == '}' || ch == ']')) return false
            else{
                when(ch){
                    ')'->{
                        if(stack.peek() == '(') stack.pop() else return false
                    }
                    '}'->{
                        if(stack.peek() == '{') stack.pop() else return false
                    }
                    ']'->{
                        if(stack.peek() == '[') stack.pop() else return false
                    }
                    else ->{
                        stack.push(ch)
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}