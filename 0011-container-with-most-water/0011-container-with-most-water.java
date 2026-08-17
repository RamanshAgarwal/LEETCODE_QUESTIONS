class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = 0;
        int i = 0;
        int j = n-1;
        while(i<j){
            int width = j-i;
            int hy8 = Math.min(height[i],height[j]);
            int currentWater = width * hy8;
            maxWater = Math.max(maxWater,currentWater);
            if(height[i]>height[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return maxWater;
    }
}