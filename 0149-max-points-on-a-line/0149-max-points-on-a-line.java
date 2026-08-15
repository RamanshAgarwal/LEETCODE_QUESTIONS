class Solution {

    public int maxPoints(int[][] points) {

        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int result = 0;

        // P1
        for (int i = 0; i < n; i++) {

            // P2
            for (int j = i + 1; j < n; j++) {

                int count = 2;

                // dx = x2 - x1
                int dx = points[j][0] - points[i][0];

                // dy = y2 - y1
                int dy = points[j][1] - points[i][1];

                // P3, P4, P5...
                for (int k = 0; k < n; k++) {

                    if (k == i || k == j) {
                        continue;
                    }

                    // dx * dy' == dy * dx'
                    int dx2 = points[k][0] - points[i][0];
                    int dy2 = points[k][1] - points[i][1];

                    if ((long) dx * dy2 == (long) dy * dx2) {
                        count++;
                    }
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}