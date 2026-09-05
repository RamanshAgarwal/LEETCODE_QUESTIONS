class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;
        for (int x : apple) {
            total += x;
        }
        Arrays.sort(capacity);
        int boxes = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            total -= capacity[i];
            boxes++;
            if (total <= 0) {
                return boxes;
            }
        }
        return boxes;
    }
}