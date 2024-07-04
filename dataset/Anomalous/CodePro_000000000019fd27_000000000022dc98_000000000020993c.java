import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[][] rowCheck = new int[n][n];
            int[][] colCheck = new int[n][n];

            // Count occurrences in rows
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = matrix[i][j];
                    rowCheck[i][value - 1]++;
                }
            }

            // Count occurrences in columns
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    colCheck[value - 1][j]++;
                }
            }

            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (rowCheck[i][j] > 1) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            int duplicateCols = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (colCheck[i][j] > 1) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += matrix[i][i];
            }

            System.out.println("Case #" + testCase + ": " + duplicateRows + " " + duplicateCols);
        }
    }
}