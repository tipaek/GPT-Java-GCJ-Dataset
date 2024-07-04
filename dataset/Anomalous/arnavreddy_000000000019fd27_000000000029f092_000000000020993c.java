import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int traceResult = calculateTrace(matrix);
            int rowDuplicates = countDuplicateRows(matrix);
            int colDuplicates = countDuplicateCols(matrix);

            System.out.printf("Case #%d: %d %d %d%n", i, traceResult, rowDuplicates, colDuplicates);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRows++;
                    break;
                }
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix) {
        int duplicateCols = 0;

        for (int col = 0; col < matrix[0].length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateCols++;
                    break;
                }
            }
        }

        return duplicateCols;
    }
}