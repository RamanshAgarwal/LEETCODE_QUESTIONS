class Solution {
    boolean allZero(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();
        int[] freq = new int[26];
        for (int i = 0; i < k; i++) {
            freq[p.charAt(i) - 'a']++;
        }
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (j < n) {
            freq[s.charAt(j) - 'a']--;
            if (j - i + 1 == k) {
                if (allZero(freq)) {
                    result.add(i);
                }
                freq[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return result;
    }
}