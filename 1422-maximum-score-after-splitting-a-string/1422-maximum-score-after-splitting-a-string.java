class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int rightOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                rightOnes++;
            }
        }
        int leftZeroes = 0;
        int maxScore = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeroes++;
            } else {
                rightOnes--;
            }
            int score = leftZeroes + rightOnes;
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}