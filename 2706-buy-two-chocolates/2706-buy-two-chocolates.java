class Solution {
    public int buyChoco(int[] prices, int money) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(min>prices[i]){
                secMin = min;
                min = prices[i];
            }
            else if(secMin>prices[i]){
                secMin = prices[i];
            }
        }
        int cost = min + secMin;
        if(cost>money){
            return money;
        }
        return money-cost;
    }
}