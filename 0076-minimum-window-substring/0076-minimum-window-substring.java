class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int low = 0;
        int high = 0;
        int formed = 0;
        int required = need.size();
        int min_len = Integer.MAX_VALUE;
        int start = 0;
        while (high < n) {
            char ch = s.charAt(high);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (need.containsKey(ch) &&
                    window.get(ch).intValue() == need.get(ch).intValue()) {

                formed++;
            }
            while (formed == required) {

                int len = high - low + 1;

                if (len < min_len) {
                    min_len = len;
                    start = low;
                }
                char left = s.charAt(low);

                window.put(left, window.get(left) - 1);

                // Required character ki frequency kam ho gayi
                if (need.containsKey(left) &&
                        window.get(left) < need.get(left)) {

                    formed--;
                }

                low++;
            }
            high++;
        }
        if (min_len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + min_len);
    }
}