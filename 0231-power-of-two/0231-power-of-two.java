class Solution {
    public boolean isPowerOfTwo(int m) {
        return m>0 && (m&(m-1)) == 0;
    }
}