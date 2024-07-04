import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            List<int[]> ress = ss(n,k);
            if (ress.size() == 0) {
                System.out.println("Case #" + tt + ": IMPOSSIBLE");
                continue;
            }
            boolean f = false;
            for (int[] varr: ress) {
                int[][] arr = new int[n+1][n+1];
                boolean[][] row = new boolean[n+1][n+1];
                boolean[][] col = new boolean[n+1][n+1];
                for (int i = 1; i <= n; i++) {
                    arr[i][i] = varr[i-1];
                    row[i][arr[i][i]] = true;
                    col[i][arr[i][i]] = true;
                }
                f = solve(arr, 1,2, n, row, col);
                if (f) {
                    System.out.println("Case #" + tt + ": POSSIBLE");
                    for (int i = 1; i <= n; i++) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 1; j <= n; j++) {
                            if (j > 1) sb.append(" ");
                            sb.append(arr[i][j]);
                        }
                        System.out.println(sb.toString());
                    }
                    break;
                }
            }
            if (!f) System.out.println("Case #" + tt + ": IMPOSSIBLE");
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

    public static List<int[]> ss(int n, int k) {
        int up = n*n;
        Map<Integer, List<Integer>>[] dp = new HashMap[up+1];

        for (int i = 0; i <= up; i++) dp[i] = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        dp[0].put(0, l);

        for (int i = 0; i < up ;i++) {
            for (Map.Entry<Integer, List<Integer>> en: dp[i].entrySet()) {
                int count = en.getKey();
                if (count == n) continue;
                for (int j = 1; j <= n; j++) {
                    int val = i + j;
                    if (val > up) continue;
                    List<Integer> list =
                            dp[val].getOrDefault(count+1, new ArrayList<>());
                    list.add(i);
                    dp[val].put(count+1, list);
                }
            }
        }

        List<int[]> res = new ArrayList<>();
        sss(new HashSet<>(), dp, new int[n], k, n, res);
        return res;
    }

    public static void sss(Set<String> set, Map<Integer, List<Integer>>[] dp,
                           int[] arr, int k, int i, List<int[]> res) {

        if (k == 0) {
            int[] t = arr.clone();
            Arrays.sort(t);
            String s = Arrays.toString(t);
            if (set.contains(s)) return;
            set.add(s);
            res.add(t);
            return;
        }
        List<Integer> val = dp[k].getOrDefault(i, null);
        if (val == null) return;
        for (int j: val) {
            arr[i - 1] = k-j;
            sss(set, dp, arr, j, i-1, res);
            arr[i-1] = 0;
        }
    }
}
