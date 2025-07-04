class Solution {
    lateinit var combiMap:MutableMap<String,Int>

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val result = mutableListOf<String>()
        for(i in course.indices){
            val courseCnt = course[i]
            combiMap = mutableMapOf<String,Int>()
            for(order in orders){
                // println("order:$order")
                if(order.length<courseCnt) continue
                combi(0,courseCnt,0,order,"")
                // 조합 맵 카운팅이 완료됐다.
            }
            var courseMax = 0
            //    println(combiMap)
            combiMap.forEach{
                //   println("val = ${it.value}")
                courseMax = Math.max(courseMax,it.value)
            }
            //   println("courseMax = $courseMax")
            if(courseMax >=2){
                combiMap.forEach{
                    if(it.value == courseMax) result.add(it.key)
                }
            }
        }

        return result.sorted().toTypedArray()
    }

    fun combi(dep : Int,len:Int, x : Int,str:String,res : String){
        //  println("str = $str res = $res")
        if(dep == len) {
            combiMap.put(res.toCharArray().sorted().joinToString(""),combiMap.getOrPut(res.toCharArray().sorted().joinToString("")){0}+1)
        }else{
            for(i in x until str.length){
                combi(dep+1,len,i+1,str,res+str.get(i))
            }
        }
    }

}