class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n-1;
        int pos = n-1;
        while(left<=right){
            int leftsquare = nums[left] * nums[left];
            int rightsquare = nums[right] * nums[right];
            if(leftsquare>rightsquare){
                result[pos] = leftsquare;
                left++;
            }else{
                result[pos] = rightsquare;
                right--;
            }
            pos--;
        }
        return result;
    } 
}