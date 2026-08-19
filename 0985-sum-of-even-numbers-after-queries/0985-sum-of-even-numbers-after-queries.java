class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            nums[index] = nums[index] + val;
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    sum = sum + nums[j];
                }
            }
            ans[i] = sum;
        }
        return ans;
    }
}