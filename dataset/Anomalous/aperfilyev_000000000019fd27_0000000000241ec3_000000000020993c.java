import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            fillMatrix(scanner, matrix);

            int traceSum = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);
            System.out.printf("Case #%d: %d %d %d%n", caseNum, traceSum, duplicateRows, duplicateColumns);
        }
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split(" ");
            for (int col = 0; col < elements.length; col++) {
                matrix[row][col] = Integer.parseInt(elements[col]);
            }
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int traceSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int[] row : matrix) {
            if (containsDuplicates(row)) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColCount = 0;
        int matrixSize = matrix[0].length;

        for (int col = 0; col < matrixSize; col++) {
            int[] columnArray = new int[matrixSize];
            for (int row = 0; row < matrixSize; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (containsDuplicates(columnArray)) {
                duplicateColCount++;
            }
        }
        return duplicateColCount;
    }

    private static boolean containsDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int element : array) {
            if (!uniqueElements.add(element)) {
                return true;
            }
        }
        return false;
    }
}