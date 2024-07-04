import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE\n";
    private static final String POSSIBLE = "POSSIBLE\n";

    public static void main(String...args) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final StringBuilder out = new StringBuilder();
        final int testCases = scanner.nextInt();
        for (int t=1; t<=testCases; t++) {
            final int n = scanner.nextInt();
            final int k = scanner.nextInt();
            int[][] matrix = null;
            int cur = 0;
            Integer[] diags = calculateDiags(n, k, cur++);
            while (diags != null) {
                matrix = new int[n][n];
                reset(matrix, diags);
                matrix = solve(matrix);
                if (matrix != null)
                    break;
                diags = calculateDiags(n, k, cur++);
            }
            out.append("Case #").append(t).append(": ")
                .append(human(matrix));
        }
        System.out.print(out.toString());
    }

    private static void reset(int[][] matrix, Integer[] diag) {
        for (int i=0; i<matrix.length; i++)
            for (int j=0; j<matrix.length; j++) {
                if (i == j)
                    matrix[i][j] = diag[i];
                else
                    matrix[i][j] = 0;
            }
    }

    private static Integer[] calculateDiags(int length, int diagSum, int number) {
        if (diagSum < length || diagSum > length*length)
            return null;

        int[] p = new int[diagSum];
        int k = 0;
        p[k] = diagSum;
        int cur = 0;

        while (true) {
            if (isValid(p, k+1, length)) {
                if (cur == number) {
                    Integer[] ret = new Integer[length];
                    for (int i = 0; i < length; i++)
                        ret[i] = p[i];
                    return ret;
                }
                cur++;
            }
            int rem_val = 0;
            while (k >= 0 && p[k] == 1) {
                rem_val += p[k];
                k--;
            }
            if (k < 0)
                break;
            p[k]--;
            rem_val++;
            while (rem_val > p[k]) {
                p[k+1] = p[k];
                rem_val = rem_val - p[k];
                k++;
            }

            p[k+1] = rem_val;
            k++;
        }

        return null;
    }

    private static boolean isValid(int[] p, int i, int n) {
        if (i == n) {
            for (int j=0; j<i; j++) {
                if (p[j] > n)
                    return false;
            }
            return true;
        }
        return false;
    }

    private static int[][] solve(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k=1; k<= matrix.length; k++) {
                        matrix[i][j] = k;
                        if (isValid(matrix, i, j) && solve(matrix) != null) {
                            return matrix;
                        }
                        matrix[i][j] = 0;
                    }
                    return null;
                }
            }
        }
        return matrix;
    }

    private static boolean isValid(int[][] board, int row, int column) {
        return validateRows(board, row) && validateColumns(board, column);
    }

    private static boolean validateRows(int[][] matrix, int i) {
        boolean[] valid = new boolean[matrix.length];
        for (int j=0; j<matrix.length; j++) {
            if (!validate(matrix, i, j, valid)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateColumns(int[][] matrix, int j) {
        boolean[] valid = new boolean[matrix.length];
        for (int i=0; i<matrix.length; i++) {
            if (!validate(matrix, i, j, valid)) {
                return false;
            }
        }
        return true;
    }

    static boolean validate(int[][] matrix, int i, int j, boolean[] valid) {
        if (matrix[i][j] != 0) {
            if (!valid[matrix[i][j] - 1]) {
                valid[matrix[i][j] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static String human(int[][] matrix) {
        if (matrix == null) {
            return IMPOSSIBLE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(POSSIBLE);
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length-1; j++) {
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append(matrix[i][matrix.length-1]).append('\n');
        }
        return sb.toString();
    }
}