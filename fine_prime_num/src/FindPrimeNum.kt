class Solution {
    lateinit var visits : BooleanArray
    lateinit var sec : IntArray
    val set = mutableSetOf<Int>()
    fun solution(numbers: String): Int {
        var answer = 0
        dfs(0,numbers,"")
        //  println("set = $set")
        val limit = 10000000.0
        val primeArr = BooleanArray(limit.toInt()){true}
        primeArr[1]=false
        primeArr[0]=false
        for(i in 2 until Math.sqrt(limit).toInt()){
            for(j in i*i until limit.toInt() step i){
                if(primeArr[i]) primeArr[j] = false
            }
        }
        set.forEach{
            if(primeArr[it]) answer++
        }
        return answer
    }

    fun dfs(dep:Int, str : String, result : String){
        if(dep == str.length){
            //println(result)
            sec = IntArray(result.length)
            visits = BooleanArray(result.length)
            getP(0,result)
        }else{

            dfs(dep+1,str,result+str.get(dep))
            dfs(dep+1,str,result)

        }
    }
    fun getP(dep:Int, result :String){
        if(result == "") return
        if(dep == result.length){
            var str =""
            sec.forEach{
                str+=it
            }
            set.add(str.toInt())
        }else{
            for(i in result.indices){
                if(!visits[i]){
                    visits[i]=true
                    sec[dep] = result.get(i)-'0'
                    getP(dep+1,result)
                    visits[i]=false
                }
            }
        }
    }
}