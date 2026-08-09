class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxarea = 0 ;
        int nse[] = new int[n];
        int pse[] = new int[n];
        //next smaller element
        Stack <Integer> s = new Stack<>();
        for(int i = n-1;i>=0;i--){
            //while
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            //if else
                if(s.isEmpty()){
                    nse[i] = n;
                }else{
                    nse[i] = s.peek();
                }
            //push
            s.push(i);
        }
        //previous smaller element 
        s = new Stack<>();
        for(int i = 0;i<n;i++){
            //while
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            //if else
                if(s.isEmpty()){
                    pse[i] = -1;
                }else{
                    pse[i] = s.peek();
                }
            //push
            s.push(i);
        }
        //curr area
        for(int i = 0;i<n;i++){
            int currarea = heights[i] * (nse[i] - pse[i] - 1);
            maxarea = Math.max(maxarea, currarea);
        }
    return maxarea;
        } 
}