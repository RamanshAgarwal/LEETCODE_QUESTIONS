class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int p = requests.length;
        int time = requests[0];
        for(int i=1;i<p;i++){
            time = time + Math.abs(requests[i] - requests[i-1]);
        }
        return time;
    }
}