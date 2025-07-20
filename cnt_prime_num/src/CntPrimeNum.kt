class Solution {
    fun solution(n: Int, k: Int): Int {
        val primes = IntArray(1000001){1}
        primes[0]=0
        primes[1]=0
        for(i in 2..(Math.sqrt(1000000.0).toInt())){
            if(primes[i] == 1){
                for(j in i*i.. 1000000 step i){
                    primes[j] = 0
                }
            }
        }
        var answer: Int = 0
        println(n.toString(k))
        val bin = n.toString(k)
        val list = bin.split("0").filter{it!=""}.map{it.toInt()}
        println(list)



        return answer
    }
}