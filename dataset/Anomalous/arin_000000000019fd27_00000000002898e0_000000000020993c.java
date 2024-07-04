import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n];
                for (int j = 0; j < n; j++) {
                    int value = matrix[i][j];
                    if (seen[value - 1]) {
                        rowCount++;
                        break;
                    }
                    seen[value - 1] = true;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n];
                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    if (seen[value - 1]) {
                        colCount++;
                        break;
                    }
                    seen[value - 1] = true;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}