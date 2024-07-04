import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;
    private boolean eof = false;

    private void run() {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    private String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                eof = true;
                return "0";
            }
        }
        return st.nextToken();
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private void solve() {
        int testCount = nextInt();
        for (int test = 1; test <= testCount; test++) {
            out.print("Case #" + test + ": ");
            int n = nextInt();
            int k = nextInt();
            if (k == n + 1) {
                out.println("IMPOSSIBLE");
                continue;
            }
            int[][] matrix = new int[n][n];
            HashSet<Integer>[] rows = new HashSet[n];
            HashSet<Integer>[] columns = new HashSet[n];
            for (int i = 0; i < n; i++) {
                rows[i] = new HashSet<>();
                columns[i] = new HashSet<>();
            }
            for (int i = 0; i < n; i++) {
                int x = Math.min(n, k - (n - i - 1));
                if (i == 0 && k > n) {
                    x = 2;
                }
                k -= x;
                matrix[i][i] = x;
                rows[i].add(x);
                columns[i].add(x);
            }
            if (dfs(matrix, rows, columns, 0, 0)) {
                out.println("POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        out.print(value + " ");
                    }
                    out.println();
                }
            } else {
                out.println("IMPOSSIBLE");
            }
        }
    }

    private boolean dfs(int[][] matrix, HashSet<Integer>[] rows, HashSet<Integer>[] columns, int i, int j) {
        if (i == matrix.length) {
            return true;
        }
        if (j == matrix[i].length) {
            return dfs(matrix, rows, columns, i + 1, 0);
        }
        if (matrix[i][j] != 0) {
            return dfs(matrix, rows, columns, i, j + 1);
        }
        for (int x = 1; x <= matrix.length; x++) {
            if (!rows[i].contains(x) && !columns[j].contains(x)) {
                matrix[i][j] = x;
                rows[i].add(x);
                columns[j].add(x);
                if (dfs(matrix, rows, columns, i, j + 1)) {
                    return true;
                }
                rows[i].remove(x);
                columns[j].remove(x);
                matrix[i][j] = 0;
            }
        }
        return false;
    }
}