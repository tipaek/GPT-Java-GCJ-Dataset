import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] varr = ss(n,k);
            if (varr == null) {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
                continue;
            }
            int[][] arr = new int[n+1][n+1];
            boolean[][] row = new boolean[n+1][n+1];
            boolean[][] col = new boolean[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                arr[i][i] = varr[i-1];
                row[i][arr[i][i]] = true;
                col[i][arr[i][i]] = true;
            }
            boolean f = solve(arr, 1,2, n, row, col);
            if (!f) {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + tt + ": POSSIBLE");
                for (int i = 1; i <= n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 1; j <= n; j++) {
                        if (j > 1) sb.append(" ");
                        sb.append(arr[i][j]);
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }

    public static boolean solve(
            int[][] arr, int i, int j, int n, boolean[][] row, boolean[][] col) {
        if (i == j) {
            if (i == n) {
                return true;
            } else {
                return solve(arr, i, j+1, n, row, col);
            }
        }
        for (int x = 1; x <= n; x++) {
            if (row[i][x] || col[j][x]) {
                continue;
            }
            row[i][x] = true;
            col[j][x] = true;
            arr[i][j] = x;
            boolean f;
            if (j < n) {
                f = solve(arr, i, j+1, n, row, col);
            } else {
                f = solve(arr, i+1, 1, n, row, col);
            }
            if (f) return true;

            row[i][x] = false;
            col[j][x] = false;
            arr[i][j] = 0;
        }
        return false;
    }

    public static int[] ss(int n, int k) {
        int up = n*n;
        Map<Integer, Integer>[] dp = new HashMap[up+1];

        for (int i = 0; i <= up; i++) dp[i] = new HashMap<>();
        dp[0].put(0, 0);

        for (int i = 0; i < up ;i++) {
            for (Map.Entry<Integer, Integer> en: dp[i].entrySet()) {
                int count = en.getKey();
                if (count == n) continue;
                for (int j = 1; j <= n; j++) {
                    int val = i + j;
                    if (val > up) continue;
                    dp[val].put(count+1, i);
                }
            }
        }
        int[] res = new int[n];
        for (int i = n; i > 0; i--) {
            int val = dp[k].getOrDefault(i, -1);
            if (val == -1) return null;
            res[i-1] = k-val;
            k = val;
        }
        return res;
    }

}
