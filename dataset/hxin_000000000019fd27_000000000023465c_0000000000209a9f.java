import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            String S = in.next();
            String ans;
            int cur = 0;
            StringBuilder sb = new StringBuilder();
            S+='0';
            for (char ch : S.toCharArray()) {
                int d = (ch) - '0';
                if(d == cur) {
                    sb.append(d);
                }
                else {
                    int v = d;
                    while (v < cur) {
                        sb.append(')');
                        v++;
                    }
                    while (v > cur) {
                        sb.append('(');
                        v--;
                    }
                    sb.append(d);
                }
                cur = d;
            }

            System.out.println("Case #" + t + ": " + sb.substring(0, sb.length()-1));
        }
    }
}