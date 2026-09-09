class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long base = 1000;
        int commas = 1;
        while(base<=n){
            long next = base * 1000-1;
            long end = Math.min(n,next);
            ans = ans + (end-base+1) * commas;
            base = base * 1000;
            commas++;
        }
        return ans;
    }
}