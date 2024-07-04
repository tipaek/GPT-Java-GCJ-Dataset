import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private final Scanner scanner;
    private final PrintStream out;

    public Solution(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(System.in, System.out);
        solution.run();
    }

    public void run() {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            evaluateTestCase(i, matrix);
        }
    }

    private void evaluateTestCase(int testCaseNumber, int[][] matrix) {
        int trace = calculateTrace(matrix);
        int invalidRows = countInvalidRows(matrix);
        int invalidColumns = countInvalidColumns(matrix);
        out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, invalidRows, invalidColumns);
    }

    private int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countInvalidRows(int[][] matrix) {
        int invalidRows = 0;
        for (int[] row : matrix) {
            Set<Integer> rowSet = new HashSet<>();
            for (int value : row) {
                rowSet.add(value);
            }
            if (rowSet.size() != matrix.length) {
                invalidRows++;
            }
        }
        return invalidRows;
    }

    private int countInvalidColumns(int[][] matrix) {
        int invalidColumns = 0;
        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> colSet = new HashSet<>();
            for (int[] row : matrix) {
                colSet.add(row[col]);
            }
            if (colSet.size() != matrix.length) {
                invalidColumns++;
            }
        }
        return invalidColumns;
    }
}