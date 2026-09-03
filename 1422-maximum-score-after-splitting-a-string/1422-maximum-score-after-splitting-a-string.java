class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int maxScore = 0;
        for(int i=0;i<n-1;i++){
            int leftZeroes = 0;
            int rightOnes = 0;
            for(int j=0;j<=i;j++){
                if(s.charAt(j) == '0'){
                    leftZeroes++;
                }
            }
            for(int j=i+1;j<n;j++){
                if(s.charAt(j) == '1'){
                    rightOnes++;
                }
            }
            int score = leftZeroes + rightOnes;
            maxScore = Math.max(maxScore,score);
        }
        return maxScore;
    }
}