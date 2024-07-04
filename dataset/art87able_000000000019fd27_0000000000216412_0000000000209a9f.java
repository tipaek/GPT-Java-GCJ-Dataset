
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            for (int j = 0; j < s.length(); j++) {
                int digit = chars[j]-'0';
                if (digit>prev) {
                    for (int k = 0; k < digit - prev; k++) {
                        sb.append("(");
                    }
                } else {
                    for (int k = 0; k < prev - digit; k++) {
                        sb.append(")");
                    }
                }
                sb.append(digit);
                prev = digit;
            }
            for (int k = 0; k < prev; k++) {
                sb.append(")");
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}
