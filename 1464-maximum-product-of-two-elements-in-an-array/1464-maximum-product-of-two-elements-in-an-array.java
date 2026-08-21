class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int largest = nums[n-1];
        int secLargest = nums[n-2];
        return (largest-1)*(secLargest-1);
    }
}