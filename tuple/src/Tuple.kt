class Solution {
    fun solution(s: String): IntArray {
        val ch = IntArray(100001){0}
        val res = mutableListOf<Int>()
        val str =s.trim('{').trim('}')
        val list = str.split("},{").sortedWith({a,b->a.length-b.length})
        list.forEach{
            // println("it = $it")
            it.split(",").map{it.toInt()}.forEach{
                // println("2it = $it")
                if(ch[it] == 0) {
                    ch[it]=1
                    res.add(it)
                }
            }
        }



        return res.toIntArray()
    }
}