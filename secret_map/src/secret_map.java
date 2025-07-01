class Solution {
    int len;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        len = n;

        for(int i =0; i<n;i++){
            String bin1 = Integer.toBinaryString(arr1[i]);
            String bin2 = Integer.toBinaryString(arr2[i]);

            String binary1 = getStr(bin1,n);
            String binary2 = getStr(bin2,n);
            String row = "";
            for(int j=0; j<n;j++){
                String b1 = binary1.substring(j,j+1);
                String b2 = binary2.substring(j,j+1);
                if(b1.equals("1")  || b2.equals("1")){
                    row+="#";
                }else{
                    row+=" ";
                }

            }
            answer[i]=row;

        }
        return answer;
    }
    String getStr(String str, int len){
        if(str.length() == len) return str;
        else{
            int diff = len - str.length();
            String zeros = "";
            for(int i=0; i<diff;i++){
                zeros+="0";
            }
            return zeros+str;
        }
    }
}