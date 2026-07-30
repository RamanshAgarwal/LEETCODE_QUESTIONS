class Solution {
    public int minTimeToType(String word) {

        char curr = 'a';
        int time = 0;

        for (char ch : word.toCharArray()) {

            int diff = Math.abs(curr - ch);

            time += Math.min(diff, 26 - diff);

            time += 1;

            curr = ch;
        }

        return time;
    }
}