class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            long[] curr = new long[k];
            int rem = num % k;
            curr[rem]++;
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRem = (int) ((long) r * rem % k);
                    curr[newRem] += dp[r];
                }
            }
            for (int r = 0; r < k; r++) {
                ans[r] += curr[r];
            }
            dp = curr;
        }
        return ans;
    }
}