class Solution {
    public int reverseDegree(String s) {
        int answer = 0 ;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int reverse = 26 - (ch - 'a');
            answer = answer + (reverse)*(i+1);
        }
        return answer;
    }
}