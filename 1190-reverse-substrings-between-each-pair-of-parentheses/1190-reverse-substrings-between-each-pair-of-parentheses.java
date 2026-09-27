
class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch != ')') {
                stack.push(ch);
            } 
            else {
                StringBuilder temp = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() != '(') {
                    temp.append(stack.pop());
                }

                stack.pop(); // remove '('

                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.reverse().toString();
    }
}