import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposedMatrix = new int[matrixSize][matrixSize];
            int duplicateRows = 0, duplicateCols = 0, trace = 0;

            // Reading matrix and calculating trace
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    transposedMatrix[row][col] = matrix[row][col];
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Checking for duplicate rows
            for (int row = 0; row < matrixSize; row++) {
                boolean[] seen = new boolean[matrixSize];
                for (int col = 0; col < matrixSize; col++) {
                    int value = matrix[row][col];
                    if (seen[value - 1]) {
                        duplicateRows++;
                        break;
                    }
                    seen[value - 1] = true;
                }
            }

            // Checking for duplicate columns
            for (int col = 0; col < matrixSize; col++) {
                boolean[] seen = new boolean[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    int value = transposedMatrix[row][col];
                    if (seen[value - 1]) {
                        duplicateCols++;
                        break;
                    }
                    seen[value - 1] = true;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}