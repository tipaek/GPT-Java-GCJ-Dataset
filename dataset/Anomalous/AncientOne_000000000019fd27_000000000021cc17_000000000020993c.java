import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] copyMatrix = new int[matrixSize][matrixSize];
            int duplicateRows = 0, duplicateCols = 0, trace = 0;

            // Read the matrix and compute the trace
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    copyMatrix[row][col] = matrix[row][col];
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for duplicate rows
            for (int row = 0; row < matrixSize; row++) {
                boolean[] seen = new boolean[matrixSize];
                for (int col = 0; col < matrixSize; col++) {
                    int value = matrix[row][col] - 1;
                    if (seen[value]) {
                        duplicateRows++;
                        break;
                    } else {
                        seen[value] = true;
                    }
                }
            }

            // Check for duplicate columns
            for (int col = 0; col < matrixSize; col++) {
                boolean[] seen = new boolean[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    int value = copyMatrix[row][col] - 1;
                    if (seen[value]) {
                        duplicateCols++;
                        break;
                    } else {
                        seen[value] = true;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}