import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Calculate the number of rows with duplicate values
            int duplicateRows = 0;
            for (int row = 0; row < matrixSize; row++) {
                Set<Integer> uniqueValues = new HashSet<>();
                for (int col = 0; col < matrixSize; col++) {
                    if (!uniqueValues.add(matrix[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Calculate the number of columns with duplicate values
            int duplicateCols = 0;
            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> uniqueValues = new HashSet<>();
                for (int row = 0; row < matrixSize; row++) {
                    if (!uniqueValues.add(matrix[row][col])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}