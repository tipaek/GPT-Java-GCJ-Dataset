import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            String res = "";
            int prev = 0;
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                int v = Integer.parseInt("" + c);
                if(prev < v) {
                    for(int k = prev; k < v; k++) {
                        res += '(';
                    }

                } else if (prev > v) {
                    for(int k = prev; k > v; k--) {
                        res += ')';
                    }
                }
                prev = v;
                res += c;
            }
            for(int k = prev; k > 0; k--) {
                res += ')';
            }

            System.out.println("Case #" + i + ": " + res);
        }
    }
}