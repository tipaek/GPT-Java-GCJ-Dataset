import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfTests; i++) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];

        int trace = 0;

        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                matrix[row][col] = scanner.nextInt();
                if (row == col) {
                    trace += matrix[row][col];
                }
            }
        }

        int duplicateRows = countDuplicateRows(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);

        System.out.println("Case #" + (testCaseNumber++) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicateRowCount++;
                    break;
                }
            }
        }

        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumnCount = 0;

        for (int col = 0; col < matrix.length; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrix.length; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }

        return duplicateColumnCount;
    }
}