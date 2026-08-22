class Solution {
    public boolean isPathCrossing(String paths) {
        int n = paths.length();
        int x=0;
        int y=0;
        HashSet<String> set = new HashSet<>();
        set.add(x + "," + y);
        for(int i=0;i<n;i++){
            char ch = paths.charAt(i);
            if(ch == 'E'){
                x++;
            }
            else if(ch == 'W'){
                x--;
            }
            else if(ch == 'N'){
                y++;
            }
            else{
                y--;
            }
            String pos = x + "," + y;
            if(set.contains(pos)){
                return true;
            }
            set.add(pos);
        }
        return false;
    }
}