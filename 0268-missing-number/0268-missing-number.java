class Solution {
    public int missingNumber(int[] nums) {
        // int n = nums.length;
        // int naturalsum = (n*(n+1)) / 2;
        // int sum = 0;
        // for( int i=0;i<n;i++){
        //     sum = sum + nums[i];
        // }
        // return (naturalsum - sum); 
         int xor = nums.length;

        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor;
    }
}