import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTests = scanner.nextInt();
        scanner.nextLine(); // Move to the next line

        for (int testCase = 0; testCase < numberOfTests; testCase++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine(); // Move to the next line

            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            // Read the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
                scanner.nextLine(); // Move to the next line
            }

            // Calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            // Check for duplicate rows
            for (int row = 0; row < matrixSize; row++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int col = 0; col < matrixSize; col++) {
                    if (seen[matrix[row][col]]) {
                        duplicateRows++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Check for duplicate columns
            for (int col = 0; col < matrixSize; col++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int row = 0; row < matrixSize; row++) {
                    if (seen[matrix[row][col]]) {
                        duplicateCols++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Output the result
            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}