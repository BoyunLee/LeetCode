class Solution {
    public boolean isValid(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if(!matches(top, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private boolean matches (char open, char close) {
        return (open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']');
    }
}