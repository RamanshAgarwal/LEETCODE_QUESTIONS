class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[] dirs = {-1, 0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    continue;
                }

                long sum = 0;
                java.util.Stack<int[]> stack = new java.util.Stack<>();

                stack.push(new int[]{i, j});
                sum += grid[i][j];
                grid[i][j] = 0;

                while (!stack.isEmpty()) {
                    int[] cell = stack.pop();
                    int x = cell[0];
                    int y = cell[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dirs[d];
                        int ny = y + dirs[d + 1];

                        if (nx >= 0 && nx < m &&
                            ny >= 0 && ny < n &&
                            grid[nx][ny] > 0) {

                            sum += grid[nx][ny];
                            grid[nx][ny] = 0;

                            stack.push(new int[]{nx, ny});
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}