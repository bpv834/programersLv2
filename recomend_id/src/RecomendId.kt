class Solution {
    fun solution(new_id: String): String {
        val lowerStr = new_id.lowercase()
        val exceptStr = exceptChar(lowerStr)
        var exceptDotStr = exceptDot(exceptStr)
        exceptDotStr = exceptDotStr.trim('.')
        if(exceptDotStr == "") exceptDotStr = "a"
        if(exceptDotStr.length>15) exceptDotStr = exceptDotStr.take(15)
        exceptDotStr = exceptDotStr.trim('.')
        if(exceptDotStr.length<=2){
            val last = exceptDotStr.get(exceptDotStr.length-1)
            for(i in 0 until 3-exceptDotStr.length){
                exceptDotStr+= last
            }
        }
        return exceptDotStr
    }

    fun exceptChar(str: String): String {
        val sb = StringBuilder()

        for (i in str.indices) {
            if (str.get(i) in '0'..'9' ||
                str.get(i) in 'a'..'z' ||
                str.get(i) == '-' ||
                str.get(i) == '_' ||
                str.get(i) == '.'
            )  sb.append(str.get(i))

        }
        return sb.toString()
    }
    fun exceptDot(str:String):String{
        val sb = StringBuilder()
        var isDotEnd = false
        for(i in str.indices){
            if(str.get(i) == '.'){
                if(isDotEnd){

                }else{
                    sb.append(str.get(i))
                    isDotEnd=true
                }

            }else{
                isDotEnd = false
                sb.append(str.get(i))
            }
        }
        return sb.toString()
    }

}
