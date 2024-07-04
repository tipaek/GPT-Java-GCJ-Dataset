import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int a = 1; a <= t; ++a) {
            int d = 0;
            StringBuilder res = new StringBuilder("");
            for (char c : in.next().toCharArray()) {
                int i = c - '0';
                int r = i - d;
                for (int j = 0; j < Math.abs(r); j++) {
                    res.append(r > 0 ? '(' : ')');
                }
                d += r;
                res.append(c);
            }
            for (int j = 0; j < d; j++) {
                res.append(')');
            }
            System.out.println(String.format("Case #1: %s", res));
        }
    }
}