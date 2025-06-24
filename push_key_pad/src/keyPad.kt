import java.util.*
class Solution1 {
    lateinit var posMap : MutableMap<Int,Pair<Int,Int>>
    lateinit var leftPosition: Pair<Int,Int>
    lateinit var rightPosition: Pair<Int,Int>

    fun solution(numbers: IntArray, hand: String): String {
        val keyList = intArrayOf(1,2,3,4,5,6,7,8,9,11,0,12)
        var keyIdx = 0
        val sb = StringBuilder()
        posMap = mutableMapOf()
        for(i in 0..3){
            for(j in 0..2){
                posMap[keyList[keyIdx++]] = Pair(i,j)
            }
        }

        leftPosition = posMap[11]!!
        rightPosition = posMap[12]!!

        //println("왼손 $leftPosition 오른손 $rightPosition")
        for(num in numbers){
            sb.append(getPosition(num,hand))
            //    println("왼손 $leftPosition 오른손 $rightPosition")
        }
        return sb.toString()
    }

    fun getPosition(num: Int, hand:String):String{
        var result = "L"

        if(num == 1 || num == 4 || num ==7){
            when(num){
                1->{
                    leftPosition = posMap[1]!!
                }
                4->{
                    leftPosition = posMap[4]!!
                }
                7->{
                    leftPosition = posMap[7]!!
                }
            }
        }else if(num == 3 || num == 6 || num == 9){
            result="R"
            when(num){
                3->{
                    rightPosition = posMap[3]!!
                }
                6->{
                    rightPosition = posMap[6]!!
                }
                9->{
                    rightPosition = posMap[9]!!
                }
            }
        }else{
            when(num){
                2->{
                    val pos2 = posMap[2]!!
                    // 왼손과 2버튼의 거리
                    val disFromLeft = getDistance(leftPosition, pos2)
                    // 오른손과 2버튼의 거리
                    val disFromRight = getDistance(rightPosition, pos2)
                    // 왼손이 가깝다면
                    if(disFromLeft < disFromRight){
                        result = "L"
                        leftPosition = pos2
                    }else if(disFromLeft > disFromRight){
                        // 오른손이 가깝다면
                        result = "R"
                        rightPosition = pos2
                    }else{
                        // 둘이 같다면
                        if(hand =="left"){
                            // 왼손잡이라면
                            result = "L"
                            leftPosition = pos2
                        }else{
                            // 오른손잡이라면
                            result = "R"
                            rightPosition = pos2
                        }

                    }
                }
                5->{
                    val pos5 = posMap[5]!!
                    // 왼손과 5버튼의 거리
                    val disFromLeft = getDistance(leftPosition, pos5)
                    // 오른손과 5버튼의 거리
                    val disFromRight = getDistance(rightPosition, pos5)
                    // 왼손이 가깝다면
                    if(disFromLeft < disFromRight){
                        result = "L"
                        leftPosition = pos5
                    }else if(disFromLeft > disFromRight){
                        // 오른손이 가깝다면
                        result = "R"
                        rightPosition = pos5
                    }else{
                        // 둘이 같다면
                        if(hand =="left"){
                            // 왼손잡이라면
                            result = "L"
                            leftPosition = pos5
                        }else{
                            // 오른손잡이라면
                            result = "R"
                            rightPosition = pos5
                        }

                    }
                }
                8->{
                    val pos8 = posMap[8]!!
                    // 왼손과 8버튼의 거리
                    val disFromLeft = getDistance(leftPosition, pos8)
                    // 오른손과 8버튼의 거리
                    val disFromRight = getDistance(rightPosition, pos8)
                    // 왼손이 가깝다면
                    if(disFromLeft < disFromRight){
                        result = "L"
                        leftPosition = pos8
                    }else if(disFromLeft > disFromRight){
                        // 오른손이 가깝다면
                        result = "R"
                        rightPosition = pos8
                    }else{
                        // 둘이 같다면
                        if(hand =="left"){
                            // 왼손잡이라면
                            result = "L"
                            leftPosition = pos8
                        }else{
                            // 오른손잡이라면
                            result = "R"
                            rightPosition = pos8
                        }

                    }
                }
                0->{
                    val pos0 = posMap[0]!!
                    // 왼손과 0버튼의 거리
                    val disFromLeft = getDistance(leftPosition, pos0)
                    // 오른손과 0버튼의 거리
                    val disFromRight = getDistance(rightPosition, pos0)
                    // 왼손이 가깝다면
                    if(disFromLeft < disFromRight){
                        result = "L"
                        leftPosition = pos0
                    }else if(disFromLeft > disFromRight){
                        // 오른손이 가깝다면
                        result = "R"
                        rightPosition = pos0
                    }else{
                        // 둘이 같다면
                        if(hand =="left"){
                            // 왼손잡이라면
                            result = "L"
                            leftPosition = pos0
                        }else{
                            // 오른손잡이라면
                            result = "R"
                            rightPosition = pos0
                        }

                    }
                }
            }

        }
        return result
    }

    // 거리 구하는 메서드
    fun getDistance(stPosition : Pair<Int,Int>, endPosition : Pair<Int,Int>) : Int{
        return Math.abs(stPosition.first - endPosition.first) + Math.abs(stPosition.second - endPosition.second)
    }

}

fun main() {
    val so1 = Solution1()
    val arr = intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5)
    println(so1.solution(arr,"right"))
}