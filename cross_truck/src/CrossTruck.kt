import java.util.*

data class Truck(val weight: Int, val enterTime: Int)

fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    val waiting = LinkedList(truck_weights.toList()) // 대기 트럭
    val onBridge = LinkedList<Truck>() // 다리 위 트럭들
    var time = 0
    var currentWeight = 0

    while (waiting.isNotEmpty() || onBridge.isNotEmpty()) {
        time++

        // 다리를 다 지난 트럭 제거
        if (onBridge.isNotEmpty() && time - onBridge.peek().enterTime >= bridge_length) {
            val truck = onBridge.poll()
            currentWeight -= truck.weight
        }

        // 다음 트럭 올릴 수 있으면 올림
        if (waiting.isNotEmpty() && currentWeight + waiting.peek() <= weight) {
            val nextWeight = waiting.poll()
            onBridge.offer(Truck(nextWeight, time))
            currentWeight += nextWeight
        }
    }

    return time
}

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val waitsQueue = LinkedList(truck_weights.toList())
        val resQueue = LinkedList<Pair<Int,Int>>()
        var sumW = 0
        var t = 0
        while(!waitsQueue.isEmpty() || !resQueue.isEmpty()){
            t++

            if(!resQueue.isEmpty()&&resQueue.peek().second + bridge_length == t){
                sumW-=resQueue.peek().first
                resQueue.poll()
            }

            if(resQueue.isEmpty()&& !waitsQueue.isEmpty()){
                val w = waitsQueue.poll()
                resQueue.add(Pair(w,t))
                sumW += w
            } else{
                if(!waitsQueue.isEmpty()&&sumW+waitsQueue.peek()<=weight){
                    val w = waitsQueue.poll()
                    resQueue.add(Pair(w,t))
                    sumW += w
                }
            }

        }
        return t
    }
}