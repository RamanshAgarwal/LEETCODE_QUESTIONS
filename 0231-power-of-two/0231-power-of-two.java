class Solution {
    public boolean isPowerOfTwo(int m) {
        if (m <= 0) return false;
        return (m&(m-1)) == 0;
    }
}