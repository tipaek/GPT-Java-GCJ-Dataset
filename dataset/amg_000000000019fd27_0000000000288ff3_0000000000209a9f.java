import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();


            solve(s, i);
        }
    }

    public static void solve(String s, int testNum) {
        String q = "";

        int depth = 0;

        int len = s.length();
        for(int i = 0; i < len; i++) {
            int num = s.charAt(i) - '0';
            while(num > depth) {
                depth++;
                q += "(";
            }

            while(num < depth) {
                depth--;
                q += ")";
            }

            q += s.charAt(i);
        }

        while(depth > 0) {
            depth--;
            q += ")";
        }

        System.out.println("Case #" + testNum + ": " + q);
    }
}