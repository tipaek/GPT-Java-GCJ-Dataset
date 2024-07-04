
import java.io.InputStream;
import java.util.Scanner;

class Solution {
    static class Result {
        int k;
        int r;
        int c;
    }

    public Result solve(int[][] matrix) {
        int n = matrix.length;
        Result res = new Result();

        for (int i = 0; i < n; i++) {
            res.k += matrix[i][i];
        }

        for (int r = 0; r < n; r++) {
            res.r += rowRepeated(matrix, n, r);
        }

        for (int c = 0; c < n; c++) {
            res.c += colRepeated(matrix, n, c);
        }

        return res;
    }

    private int rowRepeated(int[][] matrix, int n, int row) {
        boolean[] flags = new boolean[n];
        for (int c = 0; c < n; c++) {
            int val = matrix[row][c] - 1;
            if (flags[val]) {
                return 1;
            }
            flags[val] = true;
        }
        return 0;
    }

    private int colRepeated(int[][] matrix, int n, int col) {
        boolean[] flags = new boolean[n];
        for (int r = 0; r < n; r++) {
            int val = matrix[r][col] - 1;
            if (flags[val]) {
                return 1;
            }
            flags[val] = true;
        }
        return 0;
    }

    public static void main(String[] args) {
        processInputStream(System.in);
    }

    public static void processInputStream(InputStream in) {
        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int[][] matrix = readMatrix(scanner);
            Solution s = new Solution();
            Result res = s.solve(matrix);
            System.out.printf("Case #%d: %d %d %d\n", t, res.k, res.r, res.c);
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
