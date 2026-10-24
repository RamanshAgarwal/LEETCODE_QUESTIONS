class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int maxWater = 0;
        while(i < j){
            int hy8 = Math.min(height[i],height[j]);
            int width = j-i;
            int storedWater = hy8 * width;
            maxWater = Math.max(storedWater,maxWater);
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxWater;
    }
}