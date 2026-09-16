class Solution {
    public int maximumSum(int[] arr) {

        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;

        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int newNoDelete = Math.max(arr[i], noDelete + arr[i]);

            int newOneDelete = noDelete;

            if (oneDelete != Integer.MIN_VALUE) {
                newOneDelete = Math.max(newOneDelete, oneDelete + arr[i]);
            }

            noDelete = newNoDelete;
            oneDelete = newOneDelete;

            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }

        return ans;
    }
}