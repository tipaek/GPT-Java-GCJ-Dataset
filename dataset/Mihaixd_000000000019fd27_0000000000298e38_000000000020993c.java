import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        // The number of test cases.
        int t = SCANNER.nextInt();

        for (int i = 0; i < t; i++) {
            solveTest(i);
        }
    }

    private static void solveTest(int testNumber) {
        int trace = 0;
        int n = SCANNER.nextInt();
        int[][] matrix = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = SCANNER.nextInt();
            }
        }
        // Compute trace.
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        // Check duplicates on rows.
        long badRows =
                Arrays.stream(matrix)
                        .map(row -> Arrays.stream(row).distinct().count())
                        .filter(value -> value != n)
                        .count();
        // Check duplicates on columns.
        long badColumns =
                IntStream.range(0, n)
                        .mapToLong(
                                c ->
                                        IntStream.range(0, n)
                                                .map(r -> matrix[r][c])
                                                .distinct()
                                                .count())
                        .filter(value -> value != n)
                        .count();

        System.out.println(
                String.format("Case #%d: %d %d %d", testNumber, trace, badRows, badColumns));
    }

    private static int[][] readInputMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {}
        }
        return matrix;
    }
}
