import java.util.*;
import java.io.*;

class Solution {
    public static String maxDepth(String S) {
        int n = S.length();
        int openCount = 0;
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int val = Character.getNumericValue(S.charAt(i));
            
            if (stack.isEmpty()) {
                for (int k = 0; k < val; k++) {
                    stack.push("(");
                    openCount++;
                }
                stack.push(String.valueOf(val));
                for (int k = val; k > 0; k--) {
                    stack.push(")");
                    openCount--;
                }
                continue;
            }
            
            while (!stack.isEmpty() && stack.peek().equals(")") && val > 0) {
                stack.pop();
                openCount++;
                val--;
            }
            
            for (int k = 0; k < val; k++) {
                stack.push("(");
                openCount++;
            }
            
            stack.push(String.valueOf(val));
            
            while (openCount > 0) {
                stack.push(")");
                openCount--;
            }
        }
        
        return stringify(stack);
    }

    public static String stringify(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String S = in.next();
            System.out.println("Case #" + i + ": " + maxDepth(S));
        }
    }
}