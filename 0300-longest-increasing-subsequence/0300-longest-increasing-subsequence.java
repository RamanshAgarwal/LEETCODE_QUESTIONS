class Solution {

    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, -1, dp);
    }

    public int solve(int[] nums, int index, int prev, int[][] dp) {

        if (index == nums.length) {
            return 0;
        }

        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        int skip = solve(nums, index + 1, prev, dp);

        int take = 0;

        if (prev == -1 || nums[index] > nums[prev]) {
            take = 1 + solve(nums, index + 1, index, dp);
        }

        return dp[index][prev + 1] = Math.max(take, skip);
    }
}