class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
            }
        }
        int[] ans = new int[m * n];
        int index = 0;
        for (int key = 0; key <= m + n - 2; key++) {
            List<Integer> list = map.get(key);
            if (key % 2 == 0) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    int value = list.get(i);
                    ans[index] = value;
                    index++;
                }
            }
            else {
                for (int i = 0; i < list.size(); i++) {
                    int value = list.get(i);
                    ans[index] = value;
                    index++;
                }
            }
        }
        return ans;
    }
}