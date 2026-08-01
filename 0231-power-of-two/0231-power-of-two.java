class Solution {
    public boolean isPowerOfTwo(int m) {
          if (m <= 0)
            return false;

        long n = 1;

        while (n < m) {
            n <<= 1;
        }

        return n == m;
    }
}