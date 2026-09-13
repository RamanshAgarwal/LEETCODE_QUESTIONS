class Solution {
    public boolean checkIfPangram(String sentence) {
        int freq[] = new int[26];
        int n = sentence.length();
        for(int i=0;i<n;i++){
            char ch = sentence.charAt(i);
            freq[ch-'a']++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i] == 0){
                return false;
            }
        }
        return true;
    }
}