class Solution {
    public int maxProduct(int[] arr) {
        int n = arr.length;
        int maxEnding = arr[0];
        int minEnding = arr[0];
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            int choice1 = arr[i];
            int choice2 = maxEnding*arr[i];
            int choice3 = minEnding*arr[i];
            int newMax = Math.max(choice1,Math.max(choice2,choice3));
            int newMin = Math.min(choice1,Math.min(choice2,choice3));
            maxEnding = newMax;
            minEnding = newMin;
            ans = Math.max(ans,maxEnding);
        }
        return ans;
    }
}