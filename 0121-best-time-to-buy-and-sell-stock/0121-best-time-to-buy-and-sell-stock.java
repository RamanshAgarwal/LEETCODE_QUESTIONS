class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=1;i<n;i++){
            int currentPrice = prices[i];
            if(currentPrice < minPrice){
                minPrice = currentPrice;
            }
            else{
                int profit  = currentPrice - minPrice;
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        } 
        return maxProfit;
    }
}