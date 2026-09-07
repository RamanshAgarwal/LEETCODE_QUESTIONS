class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while(i<j && s.charAt(i)==s.charAt(j)){
            char ch = s.charAt(i);
            while(i<j && s.charAt(i)==ch){
                i++;
            }
            char chh = s.charAt(j);
            while(i<=j && s.charAt(j)==chh){
                j--;
            }
        }
        return j-i+1;
    }
}