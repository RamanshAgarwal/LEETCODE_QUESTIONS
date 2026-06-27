class Solution {
    public void sortColors(int[] nums) {
        int cZ = 0;
        int cO = 0;
        int cT = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cZ++;
            } else if (nums[i] == 1) {
                cO++;
            } else {
                cT++;
            }
        }
        for(int i=0;i<cZ;i++){
            nums[i]=0;
        }
        for(int i=cZ;i<cZ+cO;i++){
            nums[i]=1;
        }
        for(int i=cZ+cO;i<nums.length;i++){
            nums[i]=2;
        }
    }
}