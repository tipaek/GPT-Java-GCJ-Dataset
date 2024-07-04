import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            int[] result = analyzeMatrix(matrix);
            System.out.printf("Case #%d: %d %d %d%n", caseNum, result[0], result[1], result[2]);
        }
    }

    public static int[] analyzeMatrix(int[][] matrix) {
        int[] result = new int[3];

        // Calculate the trace of the matrix
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        result[0] = trace;

        // Count rows with repeated elements
        int repeatedRows = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                repeatedRows++;
            }
        }
        result[1] = repeatedRows;

        // Count columns with repeated elements
        int repeatedColumns = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }
        result[2] = repeatedColumns;

        return result;
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}