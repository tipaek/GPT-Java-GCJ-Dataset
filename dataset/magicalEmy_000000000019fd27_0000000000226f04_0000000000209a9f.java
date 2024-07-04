import java.util.*;
import java.io.*;
public class Solution {
    static String parenthesesNum(String s) {
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            int num = c - '0';
            sb.append(parentheses(num, prev));
            sb.append(num);
            prev = num;
        }
        sb.append(parentheses(0, prev));
        return sb.toString();

    }

    static String parentheses(int num, int prev) {
        StringBuilder sb = new StringBuilder();
        int sub = num - prev;
        if (sub > 0) {
            for (int i = 0; i < sub; i ++) {
                sb.append('(');
            }
        } else if (sub < 0) {
            for (int i = 0; i < -sub; i ++) {
                sb.append(')');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            String s = in.next();
            System.out.println("Case #" + t + ": " + parenthesesNum(s));
        }
    }
}
