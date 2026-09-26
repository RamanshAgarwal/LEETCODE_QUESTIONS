class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int key = nums[i];
            if(set.contains(key)){
                return true;
            }
            set.add(key);
        }
        return false;
    }
}