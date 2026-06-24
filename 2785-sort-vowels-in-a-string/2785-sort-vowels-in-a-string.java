class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        ArrayList<Character> vowels = new ArrayList<>();
        for(char ch:s.toCharArray()){
            if("aeiouAEIOU".indexOf(ch)!=-1){
                vowels.add(ch);
            }
        }
        Collections.sort(vowels);
        StringBuilder ans = new StringBuilder();
        int idx = 0;
        for (char ch : s.toCharArray()) {
            if ("aeiouAEIOU".indexOf(ch) != -1) {
                ans.append(vowels.get(idx++));
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}