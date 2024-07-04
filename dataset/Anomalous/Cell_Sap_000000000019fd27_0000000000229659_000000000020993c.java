import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0, rowDuplicates = 0, columnDuplicates = 0;

            // Read matrix and calculate diagonal sum
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            // Check for duplicate values in rows
            int[] countArray = new int[101]; // Assuming values are in the range [1, 100]
            for (int row = 0; row < n; row++) {
                Arrays.fill(countArray, 0);
                for (int col = 0; col < n; col++) {
                    countArray[matrix[row][col]]++;
                    if (countArray[matrix[row][col]] > 1) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < n; col++) {
                Arrays.fill(countArray, 0);
                for (int row = 0; row < n; row++) {
                    countArray[matrix[row][col]]++;
                    if (countArray[matrix[row][col]] > 1) {
                        columnDuplicates++;
                        break;
                    }
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }

        scanner.close();
    }
}