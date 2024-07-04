import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (PrintWriter w = new PrintWriter(System.out); Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            int caseNumber = 1;

            while (t-- > 0) {
                int n = in.nextInt();
                int[][] matrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = in.nextInt();
                    }
                }

                long trace = calculateTrace(matrix, n);
                long repeatedRows = countRepeatedRows(matrix, n);
                long repeatedCols = countRepeatedCols(matrix, n);

                w.printf("Case #%d: %d %d %d%n", caseNumber++, trace, repeatedRows, repeatedCols);
            }
        }
    }

    private static long calculateTrace(int[][] matrix, int n) {
        long trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static long countRepeatedRows(int[][] matrix, int n) {
        long repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static long countRepeatedCols(int[][] matrix, int n) {
        long repeatedCols = 0;
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = matrix[i][j];
            }
            if (hasDuplicates(col)) {
                repeatedCols++;
            }
        }
        return repeatedCols;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}