class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;
        int leftSum = 0;
        int rightSum = 0;
        int leftQ = 0;
        int rightQ = 0;
        for (int i = 0; i < mid; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }
        for (int i = mid; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }
        if ((leftQ + rightQ) % 2 != 0) {
            return true;
        }
        return leftSum - rightSum != (rightQ - leftQ) * 9 / 2;
    }
}