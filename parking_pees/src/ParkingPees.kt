import java.util.*
class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        // 누적시간 맵
        val timeMap = mutableMapOf<String,Int>()
        // 출차기록 맵
        val recordMap = mutableMapOf<String,String>()
        for(i in records.indices){
            val (time,num,record) = records[i].split(" ")

            if(record == "IN") recordMap.put(num,time)
            else{
                val inRecord = recordMap.remove(num)
                timeMap.put(num,calcTime(inRecord!!.split(" ")[0],time)+timeMap.getOrDefault(num,0))
            }
        }
        // 출차기록없는 차 처리
        val keyList = recordMap.keys.toMutableList()
        for(key in keyList){
            //println(it)
            val inTime = recordMap.remove(key)!!
            timeMap.put(key,calcTime(inTime,"23:59")+timeMap.getOrPut(key) { 0 })
        }

        //println(timeMap)
        // map은 mutableList로 변환불가 toList()만 존재
        val sorted = timeMap.toList().sortedWith({
                a,b -> a.first.compareTo(b.first)
        })
        //  println(sorted)
        var answer: IntArray = IntArray(sorted.size)
        for(i in answer.indices){
            answer[i] = calcFees(sorted[i].second,fees)
        }
        return answer
    }
    fun calcTime(t1:String, t2:String):Int{
        // println("t1= $t1 t2= $t2")
        //t1 =입차
        //t2 =출차
        val (t1T,t1M) = t1.split(":").map{it.toInt()}
        val (t2T,t2M) = t2.split(":").map{it.toInt()}

        val totalT1 = t1T*60+t1M
        //println(totalT1)
        val totalT2 = t2T*60+t2M
        //println(totalT2)
        return totalT2-totalT1
    }
    fun calcFees(time:Int, fees:IntArray):Int{
        val basicT = fees[0]
        val basicFee = fees[1]
        val unitT = fees[2]
        val unitFee = fees[3]

        if(time<=basicT) return basicFee
        else{
            return (basicFee + Math.ceil((time-basicT)/unitT.toDouble()) *unitFee).toInt()
        }

    }
}