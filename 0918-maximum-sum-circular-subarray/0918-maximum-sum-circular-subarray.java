class Solution {

    public int maxSubArray(int[] nums) {

        int bestEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int choice1 = bestEnding + nums[i];
            int choice2 = nums[i];

            bestEnding = Math.max(choice1, choice2);

            ans = Math.max(ans, bestEnding);
        }

        return ans;
    }

    public int minSubArray(int[] nums) {

        int bestEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int choice1 = bestEnding + nums[i];
            int choice2 = nums[i];

            bestEnding = Math.min(choice1, choice2);

            ans = Math.min(ans, bestEnding);
        }

        return ans;
    }

    public int maxSubarraySumCircular(int[] nums) {

        int maxSum = maxSubArray(nums);
        int minSum = minSubArray(nums);

        // All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        int totalSum = 0;

        for (int x : nums) {
            totalSum += x;
        }

        int circularSum = totalSum - minSum;

        return Math.max(maxSum, circularSum);
    }
}