class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer = mutableListOf<Int>()
        for(room in places){
            // 방마다 순회
            var res = 1
            for(i in room.indices){
                for(j in 0 until 5)
                // 현재 위치
                    if(room[i][j]== 'P')
                        for(k in i until 5){
                            val startL = if (k == i) j + 1 else 0 // 같은행이면 우측만 탐색, 아래행부턴 0부턴 탐색
                            for(l in startL until 5){
                                // 비교 대상위치
                                if(room[k][l]=='P')
                                    if(!isSafe(i,j,k,l,room)) {
                                        res=0
                                        break
                                    }
                            }
                            if(res == 0) break
                        }//
            }
            if(res == 0) answer.add(0) else answer.add(1)
        }
        return answer.toIntArray()
    }

    fun isSafe(y:Int,x:Int, ny:Int,nx:Int,room : Array<String>):Boolean{
        println("y=$y / x=$x / ny= $ny / nx= $nx / room = ${room.joinToString()}")
        val dis = Math.abs(y-ny) + Math.abs(x-nx)
        // 같은행 or 같은 열 바로 옆자리
        if(dis == 1) return false

        // 대각선이거나 한칸 텀이 있는경우
        if(dis == 2){
            if(y==ny || x==nx){
                // 행 같을 때
                if(y==ny){
                    if(room[y][x+1] != 'X') return false
                }else{
                    // 열이 같을때
                    if(room[y+1][x] != 'X') return false
                }
            }else{
                // 대각일때
                if(x<nx){
                    // 대상이 우측 아래에 있을때
                    if(room[y][x+1] != 'X'|| room[y+1][x]!='X') return false
                }else{
                    // 대상이 좌측 아래에 있을때
                    if(room[y][x-1] != 'X'|| room[y+1][x]!='X') return false
                }
            }
        }

        return true

    }
}