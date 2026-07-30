class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            set.add(ch);
        }
        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            boolean valid = true;
            for (char ch : word.toCharArray()) {
                if (set.contains(ch)) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                count++;
        }
        return count;
    }
}