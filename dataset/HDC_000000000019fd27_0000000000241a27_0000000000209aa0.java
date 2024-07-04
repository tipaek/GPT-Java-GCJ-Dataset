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
            System.out.format("Case #%d: %s\n", t, dfs(n, k, 0, 0, new boolean[n][n], new boolean[n][n]) ? "POSSIBLE" : "IMPOSSIBLE");
        }
        br.close();
    }
    private static boolean dfs(int n, int k, int i, int j, boolean[][] row, boolean[][] col) {
        if (n == i && 0 == j) return 0 == k;
        if (n == j) return dfs(n, k, i + 1, 0, row, col);
        if (i == j && 0 == k) return false;
        for (int num = 1; num <= n; ++num) {
            if (row[i][num - 1] || col[j][num - 1] || (num > k && i == j)) continue;
            row[i][num - 1] = col[j][num - 1] = true;
            if (dfs(n, i == j ? k - num : k, i, j + 1, row, col)) return true;
            row[i][num - 1] = col[j][num - 1] = false;
        }
        return false;
    }
}