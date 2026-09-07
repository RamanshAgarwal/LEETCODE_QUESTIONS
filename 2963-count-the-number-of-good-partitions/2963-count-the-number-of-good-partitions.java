class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int M = (int)1e9+7;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }  
        int i=0;
        int j = map.get(nums[0]);
        // int j=Math.max(j,map.get(nums[0]));
        int result = 1;
        while(i<n){
            if(i>j){
                result = (result*2)%M;
            }
            j=Math.max(j,map.get(nums[i]));
            i++;
        }
        return result;
    }
}