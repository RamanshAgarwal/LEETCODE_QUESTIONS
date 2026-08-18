class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int key = i-j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        } 
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int key = i - j;
                int idx = index.getOrDefault(key, 0);
                mat[i][j] = map.get(key).get(idx);
                index.put(key, idx + 1);
            }
        }
        return mat;
    }
}