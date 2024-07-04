import java.util.Scanner;
import java.util.Arrays;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] transposedMatrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Transpose the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transposedMatrix[i][j] = matrix[j][i];
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate elements in rows
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            // Check for duplicate elements in columns
            int duplicateColumns = 0;
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(transposedMatrix[i])) {
                    duplicateColumns++;
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    // Helper method to check for duplicates in an array
    private static boolean hasDuplicates(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return true;
            }
        }
        return false;
    }
}