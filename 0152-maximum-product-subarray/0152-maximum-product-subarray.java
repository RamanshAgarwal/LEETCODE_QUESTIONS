class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int minEnding = nums[0];
        int maxEnding = nums[0];
        int maxSubArray = nums[0];
        for(int i=1;i<n;i++){
            int choice1 = nums[i];
            int choice2 = maxEnding * nums[i];
            int choice3 = minEnding * nums[i];
            int newMax = Math.max(choice1,Math.max(choice2,choice3));
            int newMin = Math.min(choice1,Math.min(choice2,choice3));
            maxEnding = newMax;
            minEnding = newMin;
            maxSubArray = Math.max(maxSubArray,maxEnding);
        }
        return maxSubArray;
    }
}



