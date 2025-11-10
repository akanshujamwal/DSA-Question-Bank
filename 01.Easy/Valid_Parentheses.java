/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "()[]{}"
 * 
 * Output: true
 * 
 * Example 3:
 * 
 * Input: s = "(]"
 * 
 * Output: false
 * 
 * Example 4:
 * 
 * Input: s = "([])"
 * 
 * Output: true
 * 
 * Example 5:
 * 
 * Input: s = "([)]"
 * 
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
class Solution {
    public char getVal(char ch) {
        switch (ch) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return ' ';
        }
    }

    public boolean isValid(String s) {
        String opening = "([{";
        String closing = ")]}";
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (opening.indexOf(ch) != -1) {
                st.push(ch);
            } else {
                if (st.size() == 0) {
                    return false;
                }
                char temp = st.pop();
                if (getVal(ch) != temp) {
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
}