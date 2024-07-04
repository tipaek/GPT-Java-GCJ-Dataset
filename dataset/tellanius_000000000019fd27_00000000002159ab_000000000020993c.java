import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            long traceSum = trace(matrix);
            int validRows = isValidRow(matrix, n);
            int validCols = isValidCol(matrix, n);

            System.out.println(String.format("Case #%d: %d %d %d", (t+1), traceSum, validRows, validCols));
        }
    }

    private static long trace(int[][] matrix) {
        long sum = 0L;
        int i = 0;
        while(i < matrix.length) {
            sum += matrix[i][i];
            i++;
        }
        return sum;
    }

    private static int isValidRow(int[][] matrix, int n) {
        int invalidRows = 0;
        for (int r = 0; r < n; r++) {
            int[] seen = new int[n+1];
            for (int c = 0; c <n; c++) {
                if (matrix[r][c] > n || seen[matrix[r][c]] == 1) {
                    invalidRows++;
                    break;
                } else {
                    seen[matrix[r][c]] = 1;
                }
            }
        }

        return invalidRows;
    }

    private static int isValidCol(int[][] matrix, int n) {
        int invalidCols = 0;
        for (int c = 0; c < n; c++) {
            int[] seen = new int[n+1];
            for (int r = 0; r <n; r++) {
                if (matrix[r][c] > n || seen[matrix[r][c]] == 1) {
                    invalidCols++;
                    break;
                } else {
                    seen[matrix[r][c]] = 1;
                }
            }
        }
        return invalidCols;
    }

}