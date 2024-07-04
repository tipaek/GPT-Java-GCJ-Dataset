import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Checking for duplicates and calculating the trace
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    // Calculate trace
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    // Check for row duplicates
                    if (rowCheck[matrix[i][j]]) {
                        rowHasDuplicate = true;
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }

                    // Check for column duplicates
                    if (colCheck[matrix[j][i]]) {
                        colHasDuplicate = true;
                    } else {
                        colCheck[matrix[j][i]] = true;
                    }
                }

                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}