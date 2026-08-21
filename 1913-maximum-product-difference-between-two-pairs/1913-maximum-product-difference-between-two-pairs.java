class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secSmallest = Integer.MAX_VALUE;
        for(int num:nums){
            if(num>largest){
                secLargest = largest;
                largest = num;
            }
            else if(num>secLargest){
                secLargest = num;
            }
            if(num<smallest){
                secSmallest = smallest;
                smallest = num;
            }
            else if(num<secSmallest){
                secSmallest = num;
            }
        }
        return (largest*secLargest)-(smallest*secSmallest);
    }
}