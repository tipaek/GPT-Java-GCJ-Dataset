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
            int[][] matrix = new int[n][n];
            matrix = fillDiag(matrix, k);
            if (matrix != null)
                matrix = solve(matrix);
            out.append("Case #").append(t).append(": ")
                .append(human(matrix));
        }
        System.out.print(out.toString());
    }

    private static int[][] fillDiag(int[][] matrix, int k) {
        if (k < matrix.length || k > matrix.length*matrix.length)
            return null;
        int[] diag = new int[matrix.length];
        int sum = 0;
        for (int i=0; i<diag.length; i++) {
            diag[i] = 1;
            sum++;
        }
        while (sum != k) {
            for (int i=0; i<diag.length && sum != k; i++) {
                diag[i]++;
                sum++;
            }
        }
        for (int i=0; i<diag.length; i++) {
            matrix[i][i] = diag[i];
        }
        return matrix;
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