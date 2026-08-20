class Solution {
    public String largestGoodInteger(String nums) {
        int n = nums.length();
        char maxChar = ' ';
        for (int i = 0; i < n-2; i++) {
            if (nums.charAt(i) == nums.charAt(i+1) && 
                nums.charAt(i+1) == nums.charAt(i+2)) {
                maxChar = (char) Math.max(maxChar, nums.charAt(i));
            }
        }
        if (maxChar == ' ') {
            return "";
        }
        return "" + maxChar + maxChar + maxChar;
    }
}