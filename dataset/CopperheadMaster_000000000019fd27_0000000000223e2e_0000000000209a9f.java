
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String str = in.next();
            int opened = 0;
            StringBuilder out = new StringBuilder();
            for (int k = 0; k < str.length(); k++) {
                char c = str.charAt(k);
                int num = (c - '0');
                if (num == opened) {
                    out.append(c);
                }
                if (num < opened) {
                    while (num < opened) {
                        out.append(')');
                        opened--;
                    }
                    out.append(c);
                }
                if (num > opened) {
                    while (num > opened) {
                        out.append('(');
                        opened++;
                    }
                    out.append(c);
                }
            }
            while (opened > 0) {
                opened--;
                out.append(')');
            }
            System.out.println("Case #" + i + ": " + (out));
        }
    }
}
