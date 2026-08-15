import java.util.*;

class Solution {

    public int[][] outerTrees(int[][] trees) {

        int n = trees.length;

        if (n <= 1) return trees;

        // Step 1: Sort points
        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        // Step 2: Lower Hull
        Deque<int[]> lower = new ArrayDeque<>();

        for (int[] p : trees) {

            while (lower.size() >= 2) {

                int[] b = lower.removeLast();
                int[] a = lower.peekLast();

                // Clockwise -> remove b
                if (cross(a, b, p) < 0) {
                    continue;
                }

                lower.addLast(b);
                break;
            }

            lower.addLast(p);
        }

        // Step 3: Upper Hull
        Deque<int[]> upper = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {

            int[] p = trees[i];

            while (upper.size() >= 2) {

                int[] b = upper.removeLast();
                int[] a = upper.peekLast();

                // Clockwise -> remove b
                if (cross(a, b, p) < 0) {
                    continue;
                }

                upper.addLast(b);
                break;
            }
            upper.addLast(p);
        }
        Set<String> seen = new HashSet<>();
        List<int[]> ans = new ArrayList<>();
        for (int[] p : lower) {
            String key = p[0] + "," + p[1];
            if (seen.add(key)) {
                ans.add(p);
            }
        }
        for (int[] p : upper) {
            String key = p[0] + "," + p[1];
            if (seen.add(key)) {
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    private long cross(int[] a, int[] b, int[] c) {
        return (long)(b[0] - a[0]) * (c[1] - a[1])
             - (long)(b[1] - a[1]) * (c[0] - a[0]);
    }
}