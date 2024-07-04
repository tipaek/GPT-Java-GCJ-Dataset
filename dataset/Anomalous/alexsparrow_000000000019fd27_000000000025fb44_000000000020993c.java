import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                trace += matrix[i][i];
            }

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[101];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        duplicateRows++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Check for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[101];
                for (int j = 0; j < n; j++) {
                    if (colCheck[matrix[j][i]]) {
                        duplicateColumns++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}