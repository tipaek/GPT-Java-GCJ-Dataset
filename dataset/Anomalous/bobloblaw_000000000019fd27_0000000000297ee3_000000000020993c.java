import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static int[][] readMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
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

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicateColumns++;
                    break;
                }
            }
        }
        return duplicateColumns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = readMatrix(matrixSize, scanner);
            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);
            System.out.printf("Case #%d: %d %d %d%n", testIndex, trace, duplicateRows, duplicateColumns);
        }
    }
}