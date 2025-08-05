class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = IntArray(2)
        var min =Int.MAX_VALUE
        var sum = sequence[0]
        var lt=0
        var rt=1

        while(lt<rt && rt<sequence.size){
            println(sum)
            when{
                sum > k->{
                    sum-=sequence[lt++]
                }

                sum < k->{
                    sum+=sequence[rt++]
                }

                sum == k ->{
                    if(rt-lt+1 < min){
                        min = rt-lt+1
                        answer[0]=lt
                        answer[1]=rt
                    }
                }
            }

        }


        return answer
    }

}

fun main() {
    val so = Solution().solution(intArrayOf(1,2,3,4,5),7)

}