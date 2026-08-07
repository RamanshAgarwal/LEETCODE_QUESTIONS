class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : stack) {
            ans.append(ch);
        }
        return ans.toString();
    }
}