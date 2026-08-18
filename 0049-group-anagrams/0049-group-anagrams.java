class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            String temp = strs[i];
            char[] arr = temp.toCharArray();
            Arrays.sort(arr);
            temp = new String(arr);
            mp.putIfAbsent(temp,new ArrayList<>());
            mp.get(temp).add(strs[i]);
        }
        for(List<String> list : mp.values()){
            result.add(list);
        }
        return result;
    }
}