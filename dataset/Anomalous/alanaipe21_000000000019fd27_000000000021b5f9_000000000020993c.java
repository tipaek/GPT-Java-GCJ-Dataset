import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][] matrix = new int[100][100];
        boolean[] hasOccurred = new boolean[102];

        for (int t = 0; t < testCases; t++) {
            int sum = 0, duplicateRows = 0, duplicateCols = 0;
            int n = scanner.nextInt();

            // Read the matrix and calculate the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        sum += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                resetArray(hasOccurred);
                for (int j = 0; j < n; j++) {
                    if (hasOccurred[matrix[i][j]]) {
                        duplicateRows++;
                        break;
                    } else {
                        hasOccurred[matrix[i][j]] = true;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                resetArray(hasOccurred);
                for (int i = 0; i < n; i++) {
                    if (hasOccurred[matrix[i][j]]) {
                        duplicateCols++;
                        break;
                    } else {
                        hasOccurred[matrix[i][j]] = true;
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + sum + " " + duplicateRows + " " + duplicateCols);
        }
    }

    // Helper method to reset the boolean array
    private static void resetArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = false;
        }
    }
}