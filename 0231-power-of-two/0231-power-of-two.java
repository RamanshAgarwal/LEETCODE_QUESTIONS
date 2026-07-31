class Solution {
    public boolean isPowerOfTwo(int n) {
          if (n <= 0)
            return false;

        long power = 1;

        while (power < n) {
            power <<= 1;
        }

        return power == n;
    }
}