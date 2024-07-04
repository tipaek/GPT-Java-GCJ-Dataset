import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            System.out.print("Case #" + i + ": ");
            String res = build(s);
            System.out.println(res);
        }
    }

    public static String build(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for (int i = 0; i < input.length(); i++) {
            int n = input.charAt(i) - '0';
            int diff = cur - n;
            while (diff < 0) {
                sb.append("(");
                diff++;
            }
            while (diff > 0) {
                sb.append(")");
                diff--;
            }
            sb.append(n);
            cur = n;
        }
        while (cur > 0) {
            sb.append(")");
            cur--;
        }
        return sb.toString();
    }
}