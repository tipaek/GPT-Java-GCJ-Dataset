import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            // Read matrix and calculate trace
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int row = 0; row < n; row++) {
                boolean[] seen = new boolean[n + 1];
                for (int col = 0; col < n; col++) {
                    if (seen[matrix[row][col]]) {
                        rowCount++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < n; col++) {
                boolean[] seen = new boolean[n + 1];
                for (int row = 0; row < n; row++) {
                    if (seen[matrix[row][col]]) {
                        colCount++;
                        break;
                    }
                    seen[matrix[row][col]] = true;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}