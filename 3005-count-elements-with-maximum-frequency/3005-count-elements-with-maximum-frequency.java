class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int freq[] = new int[101];
        for(int x:nums){
            freq[x]++;
        }
        int max = 0;
        for(int x:freq){
            max = Math.max(max,x);
        }
        int ans = 0;
        for(int x:freq){
            if(x==max){
                ans=ans+x;
            }
        }
        return ans;
    }
}