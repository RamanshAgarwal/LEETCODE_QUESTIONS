class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int freq[] = new int[2001];
        for(int num:arr){
            freq[num+1000]++;
        }
        boolean[] seen = new boolean[1001];
        for (int f : freq) {

            if (f == 0) continue;

            if (seen[f]) {
                return false;
            }

            seen[f] = true;
        }

        return true;
    }
}
