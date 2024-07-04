import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static int d, n;
    static long[] cuts, pc;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int tt = 1; tt <= t; tt++) {
            sb.append("Case #").append(tt).append(": ");
            n = sc.nextInt();
            d = sc.nextInt();
            Long[] a = new Long[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            
            long ans = d - 1;
            
            for (int i = 0; i < n; i++) {
                cuts = new long[n];
                pc = new long[n];
                
                for (int j = 0; j < n; j++) {
                    pc[j] = a[j] / a[i];
                    cuts[j] = (a[j] % a[i] == 0) ? (a[j] / a[i]) - 1 : a[j] / a[i];
                }
                
                dp = new long[n][d + 1];
                for (long[] row : dp) {
                    Arrays.fill(row, -1);
                }
                
                ans = Math.min(dp(0, 0), ans);
            }
            
            sb.append(ans);
            if (tt != t) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }

    static long dp(int i, int cnt) {
        if (i == n) {
            return (cnt == d) ? 0 : (long) 1e18;
        }
        if (cnt == d) {
            return 0;
        }
        if (cnt > d) {
            return (long) 1e18;
        }
        if (dp[i][cnt] != -1) {
            return dp[i][cnt];
        }
        
        dp[i][cnt] = (long) 1e18;
        
        for (int j = 0; j <= d; j++) {
            if (j < pc[i]) {
                dp[i][cnt] = Math.min(dp(i + 1, cnt + j) + j, dp[i][cnt]);
            } else if (j == pc[i]) {
                dp[i][cnt] = Math.min(dp(i + 1, cnt + j) + cuts[i], dp[i][cnt]);
            } else {
                break;
            }
        }
        
        return dp[i][cnt];
    }
}