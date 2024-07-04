
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public int[][] solve(int n, int k) {
        int[][] matrix = new int[n][n];
        int[][] template = generateTemplate(n);
        if (dfs(matrix, 0, 0, n, k, template)) {
            return matrix;
        }
        return null;
    }

    private int[][] generateTemplate(int n) {
        int[][] template = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                template[r][c] = (r + c) % n + 1;
            }
        }
        return template;
    }

    private boolean dfs(int[][] matrix, int i, int sum, int n, int k, int[][] template) {
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
            if (dfs(matrix, i + 1, sum + j, n, k, template)) {
                if (fillMatrix(matrix, template)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean fillMatrix(int[][] matrix, int[][] template) {
        int n = matrix.length;
        boolean[] selected = new boolean[n];
        for (int r = 0; r < n; r++) {
            // find row in template
            for (int i = 0; i < n; i++) {
                if (template[i][r] == matrix[r][r]) {
                    if (selected[i]) {
                        return false;
                    }
                    selected[i] = true;
                    System.arraycopy(template[i], 0, matrix[r], 0, n);
                }
            }
        }
        return true;
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
