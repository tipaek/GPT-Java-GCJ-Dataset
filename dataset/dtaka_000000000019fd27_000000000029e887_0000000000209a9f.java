import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line = stdin.readLine();
        int T = Integer.parseInt(line);
        
        for (int t = 1; t <= T; t++) {
            String S = stdin.readLine();
            int l = S.length();
            int n = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < l; i++) {
                char ch = S.charAt(i);
                int d = (int)(ch - '0');
                while (d > n) {
                    sb.append('(');
                    n++;
                }
                while (d < n) {
                    sb.append(')');
                    n--;
                }
                sb.append(ch);
            }
            while (n > 0) {
                sb.append(')');
                n--;
            }
            String s = sb.toString();
            System.out.printf("Case #%d: %s\n", t, s);
        }
    }
}
