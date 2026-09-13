class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int i = 0;
        int j = n-1;
        int pos = n-1;
        while(i<=j){
            int leftSquare = nums[i]*nums[i];
            int rightSquare = nums[j]*nums[j];
            if(leftSquare>=rightSquare){
                arr[pos] = leftSquare;
                i++;
            }else{
                arr[pos] = rightSquare;
                j--;
            }
            pos--;
        }
        return arr;
    } 
}