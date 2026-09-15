class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low = 0;
        int high = 0;
        int res = 0;
        int maxFreq = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(high<n){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq,map.get(ch));
            while ((high - low + 1) - maxFreq > k) {
                char left = s.charAt(low);
                map.put(left, map.get(left) - 1);
                low++;
            }
            int len = high - low + 1;
            res = Math.max(res, len);
            high++;
        }
        return res;
    }
}