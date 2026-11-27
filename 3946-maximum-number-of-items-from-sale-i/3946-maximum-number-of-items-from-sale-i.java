
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] dp = new int[budget + 1];
        int cheapest = Integer.MAX_VALUE;

        // Find cheapest item and calculate free items
        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];

            cheapest = Math.min(cheapest, price);

            int freeCnt = 0;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    freeCnt++;
                }
            }

            // 0/1 Knapsack
            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(
                    dp[j],
                    dp[j - price] + freeCnt + 1
                );
            }
        }

        int ans = 0;

        // Spend remaining budget on cheapest items
        for (int i = 0; i <= budget; i++) {
            ans = Math.max(
                ans,
                dp[i] + (budget - i) / cheapest
            );
        }

        return ans;
    }
}
