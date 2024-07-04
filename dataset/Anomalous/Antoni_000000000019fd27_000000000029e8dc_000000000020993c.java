import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        processCases();
    }

    private static void processCases() {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowValues[col]);
                }
            }

            evaluateMatrix(matrix, caseIndex + 1);
            System.out.println();
        }

        scanner.close();
    }

    private static void evaluateMatrix(int[][] matrix, int caseNumber) {
        int[] results = computeMatrixProperties(matrix);
        System.out.printf("Case #%d: %d %d %d", caseNumber, results[0], results[1], results[2]);
    }

    private static int[] computeMatrixProperties(int[][] matrix) {
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                duplicateColumns++;
            }
        }

        return new int[]{diagonalSum, duplicateRows, duplicateColumns};
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int colIndex) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][colIndex];
        }
        return column;
    }
}