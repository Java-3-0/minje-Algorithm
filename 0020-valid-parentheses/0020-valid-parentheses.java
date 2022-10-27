
import java.util.HashMap;
import java.util.Stack;

public class Solution {

    static final String closeTags = ")]}";

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> tagMap = new HashMap<>();
        tagMap.put('(', ')');
        tagMap.put('[', ']');
        tagMap.put('{', '}');
        for (char ch : s.toCharArray()) {
            if (isCloseTag(ch)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char cur = stack.peek();
                    if (ch != tagMap.get(cur)) {
                        return false;
                    }
                    stack.pop();
                }
            } else { //open tag
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public static boolean isCloseTag(char ch) {
        return closeTags.indexOf(ch) != -1;
    }
}