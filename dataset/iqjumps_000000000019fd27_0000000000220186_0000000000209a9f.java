import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            String s = in.nextLine();
            System.out.println("Case #" + t + ": " + getNestingDepth(s));
        }
    }

    public static String getNestingDepth(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        for (char ch : s.toCharArray()) {
            int num = ch - '0';
            if (num == depth) {
                sb.append(num);
            } else if (num > depth) {
                for (;depth < num; depth++) {
                    sb.append("(");
                }
                sb.append(num);
            } else {
                for (;depth > num; depth--) {
                    sb.append(")");
                }
                sb.append(num);
            }
        }
        for (;depth > 0; depth--) {
            sb.append(")");
        }
        return sb.toString();
    }
}

