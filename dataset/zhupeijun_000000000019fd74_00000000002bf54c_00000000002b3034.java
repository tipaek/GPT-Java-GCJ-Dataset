import java.util.Scanner;

public class Solution {

    private Scanner sc = new Scanner(System.in);

    private boolean isMatch(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        boolean[][] dp = new boolean[n1 + 2][n2 + 2];
        dp[0][0] = true;
        for (int i = 1; i <= n1; ++i) {
            if (s1.charAt(i - 1) == '*' && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }

        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; ++j) {
                if (s1.charAt(i - 1) == '*') {
                    dp[i][j] |= dp[i - 1][j];
                    dp[i][j] |= dp[i - 1][j - 1];
                    dp[i][j] |= dp[i][j - 1];
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] |= dp[i - 1][j - 1];
                }
            }
        }
        return dp[n1][n2];
    }

    private String merge(String s1, String s2) {
        String p1 = s1.substring(0, s1.indexOf("*"));
        String f1 = s1.substring(s1.lastIndexOf("*") + 1);

        String p2 = s2.substring(0, s2.indexOf("*"));
        String f2 = s2.substring(s2.lastIndexOf("*") + 1);

        String pref = null;
        if (p2.equals("") || p1.startsWith(p2)) {
            pref = p1;
        } else if (p1.equals("") || p2.startsWith(p1)) {
            pref = p2;
        }

        if (pref == null) {
            return null;
        }

        String suf = null;
        if (f2.equals("") || f1.endsWith(f2)) {
            suf = f1;
        } else if (f1.equals("") || f2.endsWith(f1)){
            suf = f2;
        }

        if (suf == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pref);
        sb.append("*");
        sb.append(s1, s1.indexOf("*"), s1.lastIndexOf("*"));
        sb.append("*");
        sb.append(s2, s2.indexOf("*"), s2.lastIndexOf("*"));
        sb.append(suf);
        return sb.toString();
    }

    private void solve() {
        int N = sc.nextInt();
        String[] s = new String[N];
        for (int i = 0; i < N; ++i) {
            s[i] = sc.next();
        }

        String current = s[0];
        for (int i = 1; i < N; ++i) {
            if (!current.contains("*") && !s[i].contains("*")) {
                if (!current.equals(s[i])) {
                    current = "*";
                    break;
                }
            } else if (!current.contains("*")) {
                if (!isMatch(s[i], current)) {
                    current = "*";
                    break;
                }
            } else if (!s[i].contains("*")) {
                if (!isMatch(current, s[i])) {
                    current = "*";
                    break;
                } else {
                    current = s[i];
                }
            } else {
                current = merge(current, s[i]);
                if (current == null) {
                    current = "*";
                    break;
                }
            }
        }

        //System.out.println(current);
        if (!current.equals("*")) {
            current = current.replaceAll("\\*", "");
        }
        System.out.println(current);
    }

    private void run() {
        int T = sc.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve();
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
