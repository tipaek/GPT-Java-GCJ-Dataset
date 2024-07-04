import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nt; ++t) {
            String[] data = br.readLine().split("\\s+");
            int n = Integer.parseInt(data[0]), k = Integer.parseInt(data[1]);
            int[][] mat = new int[n][n];
            boolean res = dfs(n, k, 0, 0, new boolean[n][n], new boolean[n][n], mat);
            System.out.format("Case #%d: %s\n", t, res ? "POSSIBLE" : "IMPOSSIBLE");
            if (res) {
                for (int i = 0; i < n; ++i) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; ++j) {
                        if (0 != sb.length()) sb.append(' ');
                        sb.append(mat[i][j]);
                    }
                    System.out.println(sb.toString());
                }
            }
        }
        br.close();
    }
    private static boolean dfs(int n, int k, int i, int j, boolean[][] row, boolean[][] col, int[][] mat) {
        if (n == i && 0 == j) return 0 == k;
        if (n == j) return dfs(n, k, i + 1, 0, row, col, mat);
        if (i == j && 0 == k) return false;
        for (int num = 1; num <= n; ++num) {
            if (row[i][num - 1] || col[j][num - 1] || (num > k && i == j)) continue;
            row[i][num - 1] = col[j][num - 1] = true;
            mat[i][j] = num;
            if (dfs(n, i == j ? k - num : k, i, j + 1, row, col, mat)) return true;
            row[i][num - 1] = col[j][num - 1] = false;
        }
        return false;
    }
}