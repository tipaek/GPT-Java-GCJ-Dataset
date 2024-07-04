
import java.util.Scanner;

/**
 * Created by Acesine on 4/3/20.
 */
public class Solution {

    Scanner in = new Scanner(System.in);

    void solve() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            int open = 0;
            for (int i=0;i<s.length();i++) {
                int curr = s.charAt(i) - '0';
                if (open > curr) {
                    while (open > curr) {
                        sb.append(')');
                        open--;
                    }
                } else {
                    while (open < curr) {
                        sb.append('(');
                        open++;
                    }
                }
                sb.append(s.charAt(i));
            }
            while (open > 0) {
                sb.append(')');
                open--;
            }

            System.out.println(String.format("Case #%d: %s", t, sb.toString()));
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
