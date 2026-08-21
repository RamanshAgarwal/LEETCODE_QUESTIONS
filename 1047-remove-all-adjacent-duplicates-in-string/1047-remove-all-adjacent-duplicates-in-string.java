class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.size() == 0){
                st.push(s.charAt(i));
            }
            else if (st.peek() != s.charAt(i)) {
                st.push(s.charAt(i));
            } else {
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0)
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}