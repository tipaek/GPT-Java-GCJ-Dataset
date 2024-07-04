import java.util.*;

/**
 * Nesting Depth (5pts, 11pts)
 */
public class Solution {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            String S = in.next();
            StringBuilder sb = new StringBuilder();
            int p = 0;
            int c = 0;
            for(int i = 0; i < S.length(); i++) {
                c = S.charAt(i) - '0';
                int d = c - p;
                if(d != 0) {
                    char parenthesis = d > 0 ? '(' : ')';
                    if(d < 0) d = -d;
                    for(int x = 0; x < d; x++) {
                        sb.append(parenthesis);
                    }
                }
                sb.append(c);
                p = c;
            }
            for(int x = 0; x < c; x++) {
                sb.append(')');
            }
            System.out.format("Case #%d: %s\n", t, sb.toString());
        }
    }

}
