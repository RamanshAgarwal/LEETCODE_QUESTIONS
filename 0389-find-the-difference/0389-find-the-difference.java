class Solution {
    public char findTheDifference(String s, String t) {
        int ans = 0;
        for(char ch : s.toCharArray()){
            ans = ans ^ ch;
        }
        for(char ch : t.toCharArray()){
            ans = ans ^ ch;
        }
        return (char)ans;
    }
}