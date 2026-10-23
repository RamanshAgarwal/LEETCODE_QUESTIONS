class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int currentNumber = nums[i];
            int remaining = target - currentNumber;
            if(map.containsKey(remaining)){
                return new int[]{i,map.get(remaining)};
            }
            map.put(currentNumber,i);
        }
        return new int[]{};
    }
}

















