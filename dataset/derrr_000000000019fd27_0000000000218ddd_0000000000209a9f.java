import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.printf("Case #%d: %s%n", i, getNestingDepth(in.next()));
        }
    }

    public static String getNestingDepth(String s) {
        StringBuilder sb = new StringBuilder();
        int stack = 0;
        for (char c : s.toCharArray()) {
            int num = c - '0';
            for (int i = stack - num; i > 0; i--) {
                sb.append(')');
            }
            for (int i = num - stack; i > 0; i--) {
                sb.append('(');
            }
            sb.append(num);
            stack = num;
        }

        for (int i = stack; i > 0; i--) {
            sb.append(')');
        }

        return sb.toString();
    }
}
