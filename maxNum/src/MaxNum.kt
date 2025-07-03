class Solution {
    var max = -1L
    lateinit var nums:MutableList<Int>
    lateinit var ops :MutableList<Char>
    val visits = BooleanArray(3)
    fun solution(expression: String): Long {
        divide(expression)
        val opSet = mutableSetOf<Char>()
        ops.forEach{
            opSet.add(it)
        }
        pOps(0,CharArray(opSet.size),opSet.toMutableList())

        return max
    }
    fun divide(exp : String){
        nums = mutableListOf<Int>()
        ops = mutableListOf<Char>()
        val sb = StringBuilder()
        for(ch in exp){
            if(ch.isDigit()){
                sb.append(ch)
            }else{
                nums.add(sb.toString().toInt())
                sb.clear()
                ops.add(ch)

            }
        }
        nums.add(sb.toString().toInt())
    }

    fun pOps(dep : Int, secCh: CharArray, opList:MutableList<Char>){
        if(dep == opList.size){
            getMax(secCh)
        }else{
            for(i in opList.indices){
                if(!visits[i]){
                    visits[i]=true
                    secCh[dep] = opList.get(i)
                    pOps(dep+1,secCh,opList)
                    visits[i]=false
                }
            }
        }
    }

    fun getMax(chs : CharArray){
        // chs 는 연산자 순열값
        val copyN = nums.map{it.toLong()}.toMutableList()
        val copyO = ops.toMutableList()

        for(ch in chs){
            var i =0
            while(i<copyO.size){
                if(copyO[i] == ch){
                    val a = copyN[i]
                    val b= copyN[i+1]
                    val ch = copyO[i]
                    val value = calc(a,b,ch)
                    copyN.removeAt(i)
                    copyN[i] = value
                    copyO.removeAt(i)
                }else{
                    i++
                }
            }
            // println("chs = ${chs.joinToString(" ")} copyN[0] = $copyN")
        }
        max = Math.max(max,Math.abs(copyN[0].toLong()))
        println("max = $max")

    }

    fun calc(a : Long, b: Long, op:Char):Long{
        var result =0L
        when(op){
            '+'->{result = a+b}
            '-'->{result = a-b}
            '*'->{result = a*b}
        }
        return result
    }
}