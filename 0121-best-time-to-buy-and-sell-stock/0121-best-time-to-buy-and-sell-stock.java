class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1;i<n;i++){
            int currentPrice = prices[i];
            if(currentPrice < minPrice){
                minPrice = currentPrice;
            }
            int profit = currentPrice - minPrice;
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}

