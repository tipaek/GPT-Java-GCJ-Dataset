
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public int[][] solve(int n, int k) {
        if (k % n != 0 || k <= 0 || k > n * n) {
            return null;
        }
        int[][] matrix = generateTemplate(n);
        if (search(matrix, n, k)) {
            return matrix;
        }
        return null;
    }

    private int[][] generateTemplate(int n) {
        int[][] template = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int i = 0; i < n; i++) {
                template[r][(r + i) % n] = i + 1;
            }
        }
        return template;
    }

    private boolean search(int[][] matrix, int n, int k) {
        int sum = n;
        while (sum < k) {
            int r0 = 0;
            for (int r = 1; r < n; r++) {
                if (matrix[r][r] < matrix[r0][r0]) {
                    r0 = r;
                }
            }
            if (matrix[r0][r0] == n) {
                break;
            }
            boolean found = false;
            for (int r1 = 0; r1 < n; r1++) {
                if (r1 == r0) {
                    continue;
                }
                if (matrix[r1][r0] > matrix[r0][r0] && matrix[r0][r1] > matrix[r1][r1]) {
                    sum += n;
                    swap(matrix, r0, r1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[][] matrix, int r1, int r2) {
        int[] t = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = t;
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
