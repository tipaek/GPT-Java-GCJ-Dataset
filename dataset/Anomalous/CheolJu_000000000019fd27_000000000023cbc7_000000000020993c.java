import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfTests = scanner.nextInt();
        scanner.nextLine(); // Move to next line

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine(); // Move to next line

            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0;

            // Read matrix values
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
                scanner.nextLine(); // Move to next line
            }

            // Calculate the trace
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Check for duplicate values in rows
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

            // Check for duplicate values in columns
            for (int col = 0; col < matrixSize; col++) {
                boolean[] seen = new boolean[matrixSize + 1];
                for (int row = 0; row < matrixSize; row++) {
                    if (seen[matrix[row][col]]) {
                        duplicateColumns++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + (testIndex + 1) + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}