import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            processMatrix(testCase, matrix);
        }
    }

    private static void processMatrix(int testCaseNumber, int[][] matrix) {
        int trace = 0;
        int repeatedRows = 0;
        int repeatedColumns = 0;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();
            boolean rowHasDuplicate = false;
            boolean columnHasDuplicate = false;

            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowSet.add(matrix[i][j]) && !rowHasDuplicate) {
                    repeatedRows++;
                    rowHasDuplicate = true;
                }
                if (!columnSet.add(matrix[j][i]) && !columnHasDuplicate) {
                    repeatedColumns++;
                    columnHasDuplicate = true;
                }
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", testCaseNumber, trace, repeatedRows, repeatedColumns);
    }
}