class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var round= 1
        var lt = a.toDouble()
        var rt = b.toDouble()
        while(true){
            if(Math.abs(lt-rt)==1.0 && Math.ceil(lt/2) == Math.ceil(rt/2)) break
            lt = Math.ceil(lt.toDouble()/2)
            rt = Math.ceil(rt.toDouble()/2)
            round++
        }

        return round
    }
}