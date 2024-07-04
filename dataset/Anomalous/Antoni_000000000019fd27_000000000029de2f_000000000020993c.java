import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        processInput();
    }

    public static void processInput() {
        Scanner scanner = new Scanner(System.in);

        int numberOfCases = Integer.parseInt(scanner.nextLine());
        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                String[] rowValues = scanner.nextLine().split(" ");
                for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
                    matrix[rowIndex][colIndex] = Integer.parseInt(rowValues[colIndex]);
                }
            }

            analyzeMatrix(matrix, caseIndex + 1);
            if (caseIndex != numberOfCases - 1) {
                System.out.print("\n");
            }
        }
        scanner.close();
    }

    private static void analyzeMatrix(int[][] matrix, int caseNumber) {
        int[] results = computeMatrixMetrics(matrix);
        System.out.print("Case #" + caseNumber + ": " + results[0] + " " + results[1] + " " + results[2]);
    }

    private static int[] computeMatrixMetrics(int[][] matrix) {
        int sumDiagonal = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        for (int i = 0; i < matrix.length; i++) {
            sumDiagonal += matrix[i][i];
            boolean hasDuplicateInRow = false;
            boolean hasDuplicateInColumn = false;

            for (int j = 0; j < matrix.length; j++) {
                if (j != i && matrix[i][j] == matrix[i][0]) {
                    hasDuplicateInRow = true;
                }
                if (j != i && matrix[j][i] == matrix[0][i]) {
                    hasDuplicateInColumn = true;
                }
            }

            if (hasDuplicateInRow) duplicateRows++;
            if (hasDuplicateInColumn) duplicateColumns++;
        }

        return new int[]{sumDiagonal, duplicateRows, duplicateColumns};
    }
}