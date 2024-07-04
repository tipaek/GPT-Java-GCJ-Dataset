import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfTestCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = readMatrix(matrixSize, scanner);

            int trace = calculateTrace(matrix);
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedCols(matrix);

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, repeatedRows, repeatedCols);
        }
    }

    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        return matrix;
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
            if (containsDuplicates(row)) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix) {
        int repeatedCols = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] columnArray = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (containsDuplicates(columnArray)) {
                repeatedCols++;
            }
        }
        return repeatedCols;
    }

    private static boolean containsDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}