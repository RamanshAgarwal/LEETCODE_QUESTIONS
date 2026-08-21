class Solution {
    public int numSpecial(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;
        int rowCount[] = new int[rows];
        int colCount[] = new int[cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(nums[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int count = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if( nums[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}