
class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = Integer.MAX_VALUE;

        int[] best = new int[n];

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Carry previous best
            if (right > 0) {
                best[right] = best[right - 1];
            } else {
                best[right] = INF;
            }

            // Found a target-sum subarray
            if (sum == target) {

                int len = right - left + 1;

                // Previous subarray must end before left
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                // Current subarray becomes best
                best[right] = Math.min(best[right], len);
            }
        }

        return ans == INF ? -1 : ans;
    }
}

