class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i+=3){
            if(nums[i+2]-nums[i]>k){
                return new int[0][0];
            }
        }
        int ans[][] = new int[n/3][3];
        int row = 0;
        for(int i=0;i<n;i+=3){
            ans[row][0] = nums[i];
            ans[row][1] = nums[i+1];
            ans[row][2] = nums[i+2];
            row++;
        }
        return ans;
    }
}