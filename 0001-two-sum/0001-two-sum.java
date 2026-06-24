class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length-1;i++){
            for(int j =i+1;j<nums.length;j++){
                if((nums[i]+nums[j]) == target){
                    int answer[] = new int [2];
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        int answer[] = {-1,-1};
        return answer;
    }
}