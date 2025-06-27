import java.util.*
class Solution {
    fun solution(p: String): String {

        return dfs(p)
    }

    fun dfs(str : String):String{
        if(str == "") return str

        var u = str
        var v = ""
        var subStr = ""
        for(i in 2 until str.length step 2){
            subStr = str.substring(0,i)
            if(getParenthesesCnt(subStr,'(') == getParenthesesCnt(subStr,')')){
                u= subStr
                v= str.drop(i)
                break
            }
        }
        // 올바른 문자열이라면
        if(isTrueParentheses(u)){
            return u + dfs(v)
        }else{
            // 그렇지 않다면
            var emptyStr = "("
            emptyStr += dfs(v) +")"
            //앞, 끝 글자 제거
            u = u.substring(1,u.length-1)
            val reverseU = reverseParentheses(u)
            return emptyStr + reverseU

        }


    }
    // '(' 개수 새는 메서드
    fun getParenthesesCnt(str : String, ch : Char): Int{
        var cnt = 0
        for(idx in str.indices){
            if(str.get(idx)==ch) cnt++
        }
        return cnt
    }
    // 올바른 괄호인가?
    fun isTrueParentheses(str : String): Boolean{
        val stack = Stack<Char>()

        for(i in str.indices){
            if(str.get(i)=='(') stack.push('(')
            else{
                if(!stack.isEmpty())
                    stack.pop()
            }
        }
        if(stack.isEmpty()) return true
        return false
    }

    fun reverseParentheses(u : String):String{
        val sb = StringBuilder()
        for(i in u.indices){
            if(u.get(i)=='(') sb.append(')')
            else sb.append('(')
        }
        return sb.toString()
    }
}