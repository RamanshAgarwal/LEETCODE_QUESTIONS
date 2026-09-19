class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int left = 0;
        int right = 0;
        for (int num : nums) {
            totalSum = totalSum + num;
        }
        for (int i = 0; i < n; i++) {
            right = totalSum - left - nums[i];
            if(left == right){
                return i;
            }
            left = left + nums[i];
        }
        return -1;
    }
}