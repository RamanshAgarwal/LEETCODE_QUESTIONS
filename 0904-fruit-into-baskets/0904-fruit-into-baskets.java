class Solution {
    public int totalFruit(int[] fruits) {
        int low = 0;
        int high = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (high < fruits.length) {
            int fruit = fruits[high];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            while (map.size() > 2) {
                int left = fruits[low];
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                low++;
            }
            int len = high - low + 1;
            res = Math.max(res, len);

            high++;
        }
        return res;
    }
}