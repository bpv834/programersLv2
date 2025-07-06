class Solution {
    fun solution(s: String): String {
        val sb =StringBuilder()
        // 입력값이 소문자 대문자 랜덤이라 전부 소문자화 시키고 앞글자를 대문자로 바꾼다.
        // 공백이 연소으로 올수 있음을 인지하라. a" "" "b 라면 a "" b 이렇게 됨
        // 저렇게 되면 소문자인경우 대문자로 바꾸는곳에서 에러가 난다 왜냐면 바꿀 글자가 없기때문에
        val list = s.lowercase().split(" ").map{
            if(it!="" && it[0].isLowerCase()){
                it[0].uppercase()+it.substring(1)
            }else it
        }


        return list.joinToString(" ")
    }
}