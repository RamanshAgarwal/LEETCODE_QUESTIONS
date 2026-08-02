
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            char[] sCharArray = s.toCharArray();
            char[] tCharArray = t.toCharArray();
            Arrays.sort(sCharArray);
            Arrays.sort(tCharArray);
            return Arrays.equals(sCharArray,tCharArray);
        }
        return false;
    }
}