class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        long[] dp = new long[26];
        for (char c : s.toCharArray()) {
            int ch = c - 'a';
            long total = 1;
            for (int i = 0; i < 26; i++) {
                total = (total + dp[i]) % MOD;
            }
            dp[ch] = total;
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }
}