class Solution {
    val res = IntArray(2)
    fun solution(arr: Array<IntArray>): IntArray {
        compress(0,0,arr.size,arr)
        return res
    }
    fun compress(y:Int,x:Int,size:Int, arr: Array<IntArray>){
        //println("y= $y / x=$x arr[i][j] = ${arr[y][x]} size = $size")
        var isSame = true
        val first = arr[y][x]
        for(i in y until y+size){
            for(j in x until x+size){
                //     println("@@@@@i= $i / j=$j arr[i][j] = ${arr[i][j]}!!!!!")
                if(arr[i][j] != first) {
                    //   println("i j != first /first=$first")
                    isSame = false
                    break
                }
            }
            if(!isSame) break
        }
        //  println("for문끝")
        if(isSame){
            res[first]= res[first]+1
            //println(res.joinToString())
        }else{
            val half = size/2
            compress(y,x,half,arr)
            compress(y,x+half,half,arr)
            compress(y+half,x,half,arr)
            compress(y+half,x+half,half,arr)
        }
    }
}