
import java.util.*;
import java.io.*;

public class Solution {
    public static PrintWriter out;
    public static boolean DEBUG = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt(), cc = 0;
        Random rand = new Random();
        while (t-->0) {
            String ss = sc.next();
            String tt = sc.next();
            int dif = comp(ss, tt);
            String ans = tt;
            int d1 = dif;
            int d2 = 0;
            while (d1 - d2 > 1) {
                boolean done = false;
                for (int i = 0; i < ans.length(); i++) {
                    String tans = rem(ans, i);
                    if (d1 == comp(ss, tans) + 1) {
                        ans=tans;
                        d1--;
                        d2++;
                        done = true;
                        break;
                    }
                }
                for (int i = 0; !done && i < ans.length(); i++) {
                    for (char j = 'A'; j <= 'Z'; j++){
                        String tans = conv(j, ans, i);
                        if (d1 == comp(ss, tans) + 1) {
                            ans=tans;
                            d1--;
                            d2++;
                            done = true;
                            break;
                        }
                    }
                }
                for (int i = 0; !done && i <= ans.length(); i++) {
                    for (char j = 'A'; j <= 'Z'; j++){
                        String tans = insert(j, ans, i);
                        if (d1 == comp(ss, tans) + 1) {
                            ans=tans;
                            d1--;
                            d2++;
                            done = true;
                            break;
                        }
                    }
                }
            }
            out.printf("Case #%d: %s%n", ++cc, ans);
            if (DEBUG) {
                printDist(ans, ss);
                printDist(ans, tt);
            }
        }
        out.close();
        sc.close();
    }

    public static void printDist(String a, String b) {
        System.out.println(comp(a, b));
    }

    public static int UP = 1;
    public static int LEFT = 2;
    public static int DIAG = 3;
    public static int comp(String s, String t) {
        if (s.equals(t)) return 0;
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        int[][] dir = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
            {
                if (i == 0 || j == 0)
                {
                    dp[i][j] = Math.max(i, j);
                    if (i == 0) {
                        dir[i][j] = LEFT;
                    } else {
                        dir[i][j] = UP;
                    }
                }
                else {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dir[i][j] = DIAG;
                        dp[i][j] = dp[i-1][j-1];
                        if (dp[i][j] > dp[i-1][j] + 1) {
                            dp[i][j] = dp[i-1][j] + 1;
                            dir[i][j] = UP;
                        }
                        if (dp[i][j] > dp[i][j-1] + 1) {
                            dp[i][j] = dp[i][j-1] + 1;
                            dir[i][j] = LEFT;
                        }
                    } else {
                        dp[i][j] = n + m + 1;
                        if (dp[i][j] > dp[i-1][j] + 1) {
                            dp[i][j] = dp[i-1][j] + 1;
                            dir[i][j] = UP;
                        }
                        if (dp[i][j] > dp[i][j-1] + 1) {
                            dp[i][j] = dp[i][j-1] + 1;
                            dir[i][j] = LEFT;
                        }
                        if (dp[i][j] > dp[i-1][j-1] + 1) {
                            dp[i][j] = dp[i-1][j-1] + 1;
                            dir[i][j] = DIAG;
                        }
                    }
                }
            }
        int dist = dp[n][m];
        return dist;
    }
    public static String conv(char c, String ans,  int p2) {
        String ret = ans.substring(0,p2) + c + ans.substring(p2 + 1);
        return ret;
    }
    public static String insert(char c, String ans, int p2) {
        String ret = ans.substring(0,p2) + c + ans.substring(p2);
        return ret;
    }
    public static String rem(String ans, int p2) {
        String ret = ans.substring(0,p2) + ans.substring(p2 + 1);
        return ret;
    }
}