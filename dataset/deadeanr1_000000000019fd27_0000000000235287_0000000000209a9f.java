
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        String s;
        char r;
        StringBuilder sb = new StringBuilder();
        int p, n,m;
        for (int i = 1; i <= t; ++i) {
            p = 0;
            m=0;
            s = in.next();
            sb.setLength(0);
            for (char c : s.toCharArray()) {
                n = c - '0';

                if (p != n) {
                    r = n > p ? '(' : ')';
                    m+=n-p;
                    sb.append(repeat(r, Math.abs(n-p)));
                    p = n;
                }
                sb.append(c);
            }
            if (m != 0) {
                sb.append(repeat(')', m));
            }


            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }

    public static String repeat(char what, int howmany) {
        char[] chars = new char[howmany];
        Arrays.fill(chars, what);
        return new String(chars);
    }
}
