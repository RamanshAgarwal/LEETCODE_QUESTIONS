class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long ans = 0;

        int low = 0;

        for (int high = 0; high < nums.length; high++) {

            sum += nums[high];

            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);

            // Window size k maintain karo
            if (high - low + 1 > k) {

                int x = nums[low];

                sum -= x;

                map.put(x, map.get(x) - 1);

                if (map.get(x) == 0) {
                    map.remove(x);
                }

                low++;
            }

            // Window size k + all distinct
            if (high - low + 1 == k && map.size() == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}