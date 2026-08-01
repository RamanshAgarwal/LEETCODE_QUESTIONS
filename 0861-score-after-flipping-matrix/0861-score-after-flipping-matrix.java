class Solution {
    public int matrixScore(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Flip rows
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 0) {

                for (int j = 0; j < n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        // Step 2: Flip columns
        for (int j = 1; j < n; j++) {

            int ones = 0;

            for (int i = 0; i < m; i++) {

                if (grid[i][j] == 1)
                    ones++;
            }

            int zeros = m - ones;

            if (zeros > ones) {

                for (int i = 0; i < m; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int score = 0;

        for (int i = 0; i < m; i++) {

            int value = 0;

            for (int j = 0; j < n; j++) {

                value = value * 2 + grid[i][j];
            }

            score += value;
        }

        return score;
    }
}