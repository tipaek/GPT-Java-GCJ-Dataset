import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= T; t++) {
            String S = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int open = 0;
            for (int i = 0; i < S.length(); i++) {
                int d = S.charAt(i) - '0';
                while (open < d) {
                    sb.append('(');
                    open++;
                }
                while (open > d) {
                    sb.append(')');
                    open--;
                }
                sb.append(d);
            }
            while (open > 0) {
                sb.append(')');
                open--;
            }

            System.out.printf("Case #%d: %s\n", t, sb.toString());
        }
    }
}
