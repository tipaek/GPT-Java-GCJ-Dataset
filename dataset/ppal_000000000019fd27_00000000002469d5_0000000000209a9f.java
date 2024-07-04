import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        Stack<String> stack = new Stack<>();
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount > 0) {
                String s = line;
                String output = "";
                int j = 0;
                for (int c : s.toCharArray()) {
                    j++;
                    c = c - '0';
                    if (stack.empty()) {
                        for (int i = 1; i <= c; i++) {
                            stack.push("(");
                        }
                    } else {
                        if (!(stack.peek().equals(")") || stack.peek().equals("("))
                                && (c - Integer.parseInt(stack.peek())) > 0) {
                            int temp = Integer.parseInt(stack.peek());
                            for (int i = 1; i <= (c - temp); i++) {
                                stack.push("(");
                            }
                        }
                    }
                    stack.push(String.valueOf(c));
                    if (j >= s.length()) {
                        for (int i = 1; i <= c; i++) {
                            stack.push(")");
                        }
                    } else {
                        int cr = s.charAt(j) - '0';
                        if ((c - cr) > 0) {
                            for (int i = 1; i <= (c-cr); i++) {
                                stack.push(")");
                            }
                        }
                    }
                }
                for (String str : stack) {
                    output = output + str;
                }
                System.out.println("Case #" + (testCount) + ": " + output);
            }
            stack.clear();
            testCount++;
        }
    }
}
