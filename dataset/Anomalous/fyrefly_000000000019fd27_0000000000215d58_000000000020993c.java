import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int tn = 1; tn <= t; tn++) {
            int n = scan.nextInt();
            int trace = 0, duplicateRows = 0, duplicateCols = 0;
            int[][] matrix = new int[n][n];

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for duplicate values in rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        duplicateRows++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        duplicateCols++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + tn + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}