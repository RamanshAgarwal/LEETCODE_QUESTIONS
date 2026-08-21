class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int largest = 0;
        int secLargest = 0;
        for(int i=0;i<n;i++){
            if(nums[i]>largest){
                secLargest = largest;
                largest = nums[i];
            }
            else if (nums[i] > secLargest) {
                secLargest = nums[i];
            }
        }
        return (largest-1)*(secLargest-1);
    }
}