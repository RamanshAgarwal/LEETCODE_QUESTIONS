import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // [start, end, value, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort according to ending time
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        // dp[i][k] = best answer using first i intervals
        // with at most k intervals
        long[][] dp = new long[n + 1][5];

        // To reconstruct the selected indices
        List<Integer>[][] chosen = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                chosen[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {

            int start = arr[i - 1][0];
            int value = arr[i - 1][2];

            for (int k = 1; k <= 4; k++) {

                // Option 1: Don't take current interval
                dp[i][k] = dp[i - 1][k];
                chosen[i][k] = new ArrayList<>(chosen[i - 1][k]);

                // Find previous compatible interval
                int prev = binarySearch(arr, i - 1, start);

                long take = value + dp[prev][k - 1];

                if (take > dp[i][k]) {

                    dp[i][k] = take;

                    chosen[i][k] =
                        new ArrayList<>(chosen[prev][k - 1]);

                    chosen[i][k].add(arr[i - 1][3]);

                    Collections.sort(chosen[i][k]);

                } else if (take == dp[i][k]) {

                    List<Integer> candidate =
                        new ArrayList<>(chosen[prev][k - 1]);

                    candidate.add(arr[i - 1][3]);

                    Collections.sort(candidate);

                    if (isLexicographicallySmaller(
                            candidate, chosen[i][k])) {

                        chosen[i][k] = candidate;
                    }
                }
            }
        }

        return chosen[n][4]
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    // Find number of intervals whose end < start
    private int binarySearch(int[][] arr, int right, int start) {

        int low = 0;
        int high = right;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid][1] < start)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }


    private boolean isLexicographicallySmaller(
            List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}