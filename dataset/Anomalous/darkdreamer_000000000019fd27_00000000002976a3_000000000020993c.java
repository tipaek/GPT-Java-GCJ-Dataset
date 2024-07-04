import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateColumns = countDuplicateColumns(matrix, matrixSize);
            int diagonalSum = calculateDiagonalSum(matrix, matrixSize);

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, duplicateRows, duplicateColumns);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        boolean[] seen = new boolean[size + 1];
        int duplicateRows = 0;

        for (int i = 0; i < size; i++) {
            Arrays.fill(seen, false);
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        boolean[] seen = new boolean[size + 1];
        int duplicateColumns = 0;

        for (int i = 0; i < size; i++) {
            Arrays.fill(seen, false);
            for (int j = 0; j < size; j++) {
                if (seen[matrix[j][i]]) {
                    duplicateColumns++;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }

        return duplicateColumns;
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}