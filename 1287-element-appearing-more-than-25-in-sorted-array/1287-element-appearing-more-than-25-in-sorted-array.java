class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-n/4;i++){
            if(arr[i] == arr[i+n/4]){
                return arr[i];
            }
        }
        return -1;
    }
}