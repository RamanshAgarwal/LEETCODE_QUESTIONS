import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int low = 0;
        int high = 0;

        int res = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (high < n) {

            char ch = s.charAt(high);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // duplicate character aa gaya
            while (map.get(ch) > 1) {

                char left = s.charAt(low);

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }

                low++;
            }

            int len = high - low + 1;

            res = Math.max(res, len);

            high++;
        }

        return res;
    }
}