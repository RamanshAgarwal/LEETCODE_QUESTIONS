class Solution {
    public int countCommas(int n) {
        int ans= 0 ;
        int base = 1000;
        int commas = 1;
        while(base<=n){
            ans = ans + (n-base+1) * commas;
            base = base * 1000;
            commas++;
        }
        return ans;
    }
}