import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowCount = 0, colCount = 0;
            int[][] matrix = new int[n][n];

            // Read matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowCheck[matrix[i][j] - 1]) {
                        rowCheck[matrix[i][j] - 1] = true;
                    } else {
                        rowCount++;
                        break;
                    }
                }
            }

            // Check for duplicate values in each column
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if (!colCheck[matrix[i][j] - 1]) {
                        colCheck[matrix[i][j] - 1] = true;
                    } else {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}