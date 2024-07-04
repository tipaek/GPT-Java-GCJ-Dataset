import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.valueOf(scanner.nextLine());
        for (int i = 1; i <= t; i++) {
            String res = solve(scanner.nextLine());
            System.out.println("Case #" + i + ": " + res);
        }
        scanner.close();
    }


    private static String solve(String s) throws IOException {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                for (int j = 0; j < (c - '0'); j++) {
                    sb.append("(");
                    stack.add('(');
                }
                sb.append(c);
            } else {
                if (c == s.charAt(i - 1)) {
                    sb.append(c);
                } else if (s.charAt(i - 1) < c) {
                    int diff = c - s.charAt(i-1);
                    for (int j = 0; j < diff; j++) {
                        sb.append("(");
                        stack.add('(');
                    }
                    sb.append(c);
                } else {
                    int diff = s.charAt(i-1) - c;
                    for (int j = 0; j < diff; j++) {
                        sb.append(")");
                        stack.pop();
                    }
                    sb.append(c);
                }
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            sb.append(")");
        }
        return sb.toString();
    }
}
