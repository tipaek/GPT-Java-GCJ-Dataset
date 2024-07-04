import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner scanner;
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int diagonalSum = 0;

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    diagonalSum += matrix[i][j];
                }
            }
        }

        int duplicateRows = countDuplicateRows(matrix);
        int duplicateColumns = countDuplicateColumns(matrix);

        System.out.println("Case #" + (testCaseNumber++) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicates = 0;

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                if (!uniqueElements.add(element)) {
                    duplicates++;
                    break;
                }
            }
        }

        return duplicates;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicates = 0;
        int matrixSize = matrix.length;

        for (int col = 0; col < matrixSize; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < matrixSize; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    duplicates++;
                    break;
                }
            }
        }

        return duplicates;
    }
}