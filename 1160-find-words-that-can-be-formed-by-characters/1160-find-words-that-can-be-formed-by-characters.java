class Solution {
    public int countCharacters(String[] words, String chars) {
        char[] characters = new char[26];
        for (char ch : chars.toCharArray()) {
            characters[ch - 'a']++;
        }
        int result = 0;
        for (String word : words) {
            char[] wordCount = new char[26];
            for (char ch : word.toCharArray()) {
                wordCount[ch - 'a']++;
            }
            boolean ok = true;
            for(int i=0;i<26;i++){
                if(wordCount[i]>characters[i]){
                    ok = false;
                }
            }
            if(ok == true){
                result = result  + word.length();
            }
        }
        return result;
    }
}