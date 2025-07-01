import java.util.*
class Solution {
    var n = 0
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        n = board.size
        val resultStack = Stack<Int>()
        val stackMap = mutableMapOf<Int, Stack<Int>>()
        for (i in 0..n) {
            stackMap.getOrPut(i) {
                Stack<Int>()
            }
        }

        for (i in n - 1 downTo 0) {
            for (j in board[0].indices) {
                if(board[i][j]!=0)
                    stackMap.get(j + 1)!!.push(board[i][j])
            }
        }

        for(i in moves.indices){
            if(!stackMap[moves[i]]!!.isEmpty()){
                val pull = stackMap[moves[i]]!!.pop()
                if(!resultStack.isEmpty()&&resultStack.peek()==pull){
                    resultStack.pop()
                    answer+=2
                }else{
                    resultStack.push(pull)
                }
            }
        }


        return answer
    }
}