class Solution {
    public List<Integer> spiralOrder(int[][] nums) {
        List<Integer> ans = new ArrayList<>();
        int rows = nums.length;
        int cols = nums[0].length;
        int top = 0;
        int left = 0;
        int bottom = rows-1;
        int right = cols-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                ans.add(nums[top][i]);
            }
            top++;
            if(top>bottom) break;
            for(int i=top;i<=bottom;i++){
                ans.add(nums[i][right]);
            }
            right--;
            if(left>right) break;
            for(int i=right;i>=left;i--){
                ans.add(nums[bottom][i]);
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                ans.add(nums[i][left]);
            }
            left++;
        }
        return ans;
    }
}