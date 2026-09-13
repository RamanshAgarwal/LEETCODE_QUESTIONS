class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int max = 0;
        for (int rowShift = -n + 1; rowShift < n; rowShift++) {
            for (int colShift = -n + 1; colShift < n; colShift++) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int x = i + rowShift;
                        int y = j + colShift;
                        if (x >= 0 && x < n &&
                            y >= 0 && y < n) {
                            if (A[i][j] == 1 && B[x][y] == 1) {
                                count++;
                            }
                        }
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}