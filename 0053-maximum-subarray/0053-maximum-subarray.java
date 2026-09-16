class Solution {
    public int maxSubArray(int[] nums) {
        int bestEnding = nums[0];
        int ans = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            int choice1 = bestEnding+nums[i];
            int choice2 = nums[i];
            bestEnding = Math.max(choice1,choice2);
            ans = Math.max(ans,bestEnding);
        }
        return ans;
    }
}