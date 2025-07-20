
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        val bin = n.toString(k)
        println(bin.split("0"))
        bin.split("0").filter{it!=""}.map{it.toLong()}.forEach{
            if(isPrime(it)) answer ++
        }
        return answer
    }
    fun isPrime(num : Long):Boolean{
        if(num <=1) return false
        for(i in 2..(Math.sqrt(num.toDouble()).toLong())){
            if(num%i == 0L) return false
        }
        return true
    }
}