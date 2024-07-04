import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            System.out.println(String.format("Case #%d: %s", ks, new Solution().solve(input)));
        }
    }

    public String solve(Scanner scanner) {
        String S = scanner.next();
        String ss = "";

        for (int i = 0; i < S.length(); i++) {
            int t = S.charAt(i) - '0';
            String s = "" + t;
            while (t > 0) {
                s = "(" + s + ")";
                t--;
            }
            int m = ss.length() - 1;
            int n = 0;

            while (m >= 0 && n < s.length()) {
                if (ss.charAt(m) == ')' && s.charAt(n) == '(') {
                    ss = ss.substring(0, m);
                    s = s.substring(n + 1);
                    m = ss.length() - 1;
                }
                if (ss.charAt(m) - '0' >= 0 && ss.charAt(m) - '0' <= 9) break;
                if (s.charAt(n) - '0' >= 0 && s.charAt(n) - '0' <= 9) break;
            }

            ss += s;
        }

        return ss;
    }
}