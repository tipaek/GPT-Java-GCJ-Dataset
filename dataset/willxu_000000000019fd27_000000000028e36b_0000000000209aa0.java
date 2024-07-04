
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public int[][] solve(int n, int k) {
        int[][] matrix = new int[n][n];
        if (dfs(matrix, 0, 0, n, k)) {
            return matrix;
        }
        return null;
    }

    private boolean dfs(int[][] matrix, int i, int sum, int n, int k) {
        if (sum + (n - i) > k) {
            return false;
        }
        if (sum + (n - i) * n < k) {
            return false;
        }
        if (i == n) {
            return sum == k;
        }
        for (int j = 1; j <= n; j++) {
            matrix[i][i] = j;
            if (dfs(matrix, i + 1, sum + j, n, k)) {
                boolean[][] rowFlags = new boolean[n][n];
                boolean[][] colFlags = new boolean[n][n];
                for (int p = 0; p < n; p++) {
                    int val = matrix[p][p];
                    rowFlags[p][val - 1] = true;
                    colFlags[p][val - 1] = true;
                }
                if (fillMatrix(matrix, 0, rowFlags, colFlags)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean fillMatrix(int[][] matrix, int p, boolean[][] rowFlags, boolean[][] colFlags) {
        int n = matrix.length;
        if (p == n * n) {
            return true;
        }
        int r = p / n;
        int c = p % n;
        if (r == c) {
            return fillMatrix(matrix, p + 1, rowFlags, colFlags);
        } else {
            for (int j = 1; j <= n; j++) {
                if (rowFlags[r][j - 1] || colFlags[c][j - 1]) {
                    continue;
                }
                matrix[r][c] = j;
                rowFlags[r][j - 1] = colFlags[c][j - 1] = true;
                if (fillMatrix(matrix, p + 1, rowFlags, colFlags)) {
                    return true;
                }
                rowFlags[r][j - 1] = colFlags[c][j - 1] = false;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        processInputStream(System.in);
    }

    public static void processInputStream(InputStream in) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
        try {
            int T = scanner.nextInt();
            for (int t = 1; t <= T; t++) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                Solution s = new Solution();
                int[][] matrix = s.solve(n, k);
                printResult(t, matrix);
            }
        } finally {
            scanner.close();
        }
    }

    private static void printResult(int t, int[][] matrix) {
        System.out.printf("Case #%d: %s\n", t, matrix == null ? "IMPOSSIBLE" : "POSSIBLE");
        if (matrix != null) {
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[r].length; c++) {
                    System.out.printf("%s%d", (c == 0 ? "" : " "), matrix[r][c]);
                }
                System.out.println();
            }
        }
    }
}
