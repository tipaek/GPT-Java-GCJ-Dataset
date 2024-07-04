import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int traceValue = calculateTrace(matrix);
            int repeatedRowCount = countRepeatedRows(matrix);
            int repeatedColumnCount = countRepeatedColumns(matrix);

            System.out.printf("Case #%d: %d %d %d%n", t, traceValue, repeatedRowCount, repeatedColumnCount);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    repeatedRows++;
                    break;
                }
            }
        }

        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        int n = matrix.length;

        for (int col = 0; col < n; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    repeatedColumns++;
                    break;
                }
            }
        }

        return repeatedColumns;
    }
}