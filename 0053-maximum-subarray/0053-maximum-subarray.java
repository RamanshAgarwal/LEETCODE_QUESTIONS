class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int bestEnding = nums[0];
        int answer = nums[0];
        for(int i=1;i<n;i++){
            int choice1 = bestEnding + nums[i];
            int choice2 = nums[i];
            bestEnding = Math.max(choice1,choice2);
            answer = Math.max(bestEnding,answer);
        }
        return answer;
    }
}